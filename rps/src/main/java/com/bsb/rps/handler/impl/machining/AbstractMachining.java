package com.bsb.rps.handler.impl.machining;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.entity.BhReportPlan;
import com.bsb.rps.entity.BhSysProd;
import com.bsb.rps.entity.BhTotalRepayFlow;
import com.bsb.rps.enums.PlanReportStatus;
import com.bsb.rps.enums.ProdReportStatus;
import com.bsb.rps.handler.Machining;
import com.bsb.rps.handler.impl.step.AbstractStep;
import com.bsb.rps.handler.impl.step.StepLine;
import com.bsb.rps.manager.ProcessDateManager;
import com.bsb.rps.service.IBhReportPlanService;
import com.bsb.rps.service.IBhSysProdService;
import com.bsb.rps.util.exc.CommonErrorCode;
import com.bsb.rps.util.exc.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AbstractMachining implements Machining {
    @Value("${isAsync}")
    protected boolean isAsync;
    protected final List<String> stepNameList = new ArrayList<>();
    protected final List<AbstractStep> stepList = new ArrayList<>();

    @Resource
    protected StepLine stepLine;
    @Resource
    private ApplicationContext applicationContext;
    @Resource
    private IBhSysProdService sysProdService;
    @Resource
    private IBhReportPlanService reportPlanService;

    protected boolean judgeForD2AndCL1(String prodSubNo) {
        return this.judgeProd(prodSubNo);
    }

    protected boolean judgeForD3AndCL2(MachiningRecord record) {
        Object sourceRecord = record.getSourceRecord();
        BhReportPlan reportPlan;
        boolean termFlag = false, dateFlag = false;
        if (sourceRecord instanceof BhTotalRepayFlow) { // 有还款的贷后判断
            BhTotalRepayFlow totalRepayFlow = (BhTotalRepayFlow) sourceRecord;
            reportPlan = reportPlanService.getByOrderNo(totalRepayFlow.getOrderNo()); // 缓存中不存在,则从数据库中取
            termFlag = totalRepayFlow.getTermNo().compareTo(reportPlan.getReportTerm()) == 0
                    || totalRepayFlow.getTermNo().compareTo(reportPlan.getReportTerm() - 1) == 0;
        } else if (sourceRecord instanceof BhReportPlan) {  // 无还款的贷后判断
            reportPlan = (BhReportPlan) sourceRecord;
            dateFlag = ProcessDateManager.getProcessDate().equals(reportPlan.getReportDate());
        } else {
            throw new ServiceException(CommonErrorCode.ERROR_PARAM_NOT_MATCH.getCode(), "sourceRecord={}"+sourceRecord.toString());
        }
        
        boolean prodFlag = this.judgeProd(reportPlan.getProdSubNo());
        boolean reportPlanFlag = this.judgeReportPlanStatus(reportPlan.getReportStatus());

        return prodFlag && reportPlanFlag && (termFlag || dateFlag);
    }

    private boolean judgeProd(String prodSubNo) {
        BhSysProd sysProd = this.getSysProd(prodSubNo);
        return this.judgeProdLoop(sysProd.getLoopStatus())
                && ProdReportStatus.EFFECT.getCode().equals(sysProd.getReportStatus());
    }

    private boolean judgeReportPlanStatus(String reportPlanStatus) {
        return PlanReportStatus.NORMAL.getCode().equals(reportPlanStatus)
                || PlanReportStatus.OVERDUE.getCode().equals(reportPlanStatus);
    }

    private BhSysProd getSysProd(String prodSubNo) {
        BhSysProd sysProd = sysProdService.getByProdSubNo(prodSubNo);
        log.info("产品信息={}", sysProd);
        if (sysProd == null)
            throw new ServiceException(CommonErrorCode.ERROR_NULL_RECORD.getCode(), prodSubNo);
        return sysProd;
    }

    protected abstract boolean judgeProdLoop(String loopStatus);

    protected void D3AndCL2BuildSteps() {
        stepNameList.add("d3AndCL2RepayPlan");
        stepNameList.add("d3AndCL2RepayFlow");
        stepNameList.add("customer");
        stepNameList.add("common");
        stepNameList.add("d3AndCL2ReportPlan");
        this.createStepObj(stepNameList);
        this.useAsyncOrSync();
    }

    protected void D2AndCL1BuildSteps() {
        stepNameList.add("d2AndCL1Loan");
        stepNameList.add("d2AndCL1RepayPlan");
        stepNameList.add("customer");
        stepNameList.add("common");
        this.createStepObj(stepNameList);
        this.useAsyncOrSync();
    }

    protected void createStepObj(List<String> stepNameList) {
        log.info("执行策略类={}, 执行步骤类名称={}", this.getClass().getName(), stepNameList);
        stepNameList.forEach(stepName -> stepList.add((AbstractStep) applicationContext.getBean(stepName)));
    }

    protected void useAsyncOrSync() {
        log.info("执行策略类={}, 执行步骤类={}", this.getClass().getName(), stepList);
        if (isAsync)
            stepLine.defineAsyncExecutionSteps(stepList); // 异步并行执行
        else
            stepLine.defineSyncExecutionSteps(stepList); // 同步串行执行
    }

}
