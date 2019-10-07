package com.bsb.rps.handler;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.entity.BhLogTask;
import com.bsb.rps.enums.TaskName;
import com.bsb.rps.manager.CountDownManager;
import com.bsb.rps.service.*;
import com.bsb.rps.util.exc.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class HandlerClient implements ApplicationContextAware {
    @Value("${select.size}")
    private long size;

    private final List<Machining> creditMachiningList = new ArrayList<>(1);
    private final List<Machining> loanMachiningList = new ArrayList<>(2);
    private final List<Machining> loanAfterMachiningList = new ArrayList<>(2);

    private final List notNeedProcessData = new ArrayList();

    @Resource
    private IBhTotalCreditService totalCreditService;   // 加工授信开立/变更信息
    @Resource
    private IBhTotalLoanService totalLoanService;       // 加工借据开立/变更信息
    @Resource
    private IBhTotalRepayFlowService totalRepayFlowService; // 加工贷后有还款信息
    @Resource
    private IBhReportPlanService reportPlanService;         // 加工贷后无还款信息
    @Resource
    private IBhLogTaskService logTaskService;

    public void startHandler() {
        try {
            this.abstractHandler(TaskName.CREDIT, creditMachiningList, totalCreditService);
            this.abstractHandler(TaskName.LOAN, loanMachiningList, totalLoanService);
            this.abstractHandler(TaskName.LOAN_AFTER_HAS_REPAY, loanAfterMachiningList, totalRepayFlowService);
            this.abstractHandler(TaskName.LOAN_AFTER_NOT_REPAY, loanAfterMachiningList, reportPlanService);
        } catch (Throwable t) {
            log.error("startHandler 任务失败", t);
        }
    }

    // TODO 处理完成后需要进入入库操作,总共包括  total更改标识 + 插入报文数据 + 上报计划更新
    @SuppressWarnings("unchecked")
    private void abstractHandler(TaskName taskName, List<Machining> machiningList, IService service) {
        BhLogTask logTask = logTaskService.insert(taskName.getCode());
        List sourceRecordList;
        while (true) {
            sourceRecordList = service.list(); // 实现类重写了接口的默认实现,即实现类生效
            if (sourceRecordList.size() <= 0)
                break; // 所有记录均已处理过,退出while循环
            CountDownManager.resetCountDownLatch(sourceRecordList.size()); // 设置计数器初始化大小,每处理一条记录,计数器减1
            sourceRecordList.forEach((sourceRecord) -> {
                MachiningRecord record = new MachiningRecord();
                record.setSourceRecord(sourceRecord);
                boolean matchClassFailFlag = true; // 默认认为记录匹配不上对应执行类;若匹配成功,更改标识并在执行步骤的最后一步进行减少计数器
                for (Machining machining : machiningList) {
                    if (machining.judge(record)) {
                        machining.process(record);
                        matchClassFailFlag = false;
                        break;
                    }
                }
                if (matchClassFailFlag) {
                    CountDownManager.countDown(); // 意为该记录未匹配成功,此处减少计数器,并需要更改该记录处理状态
                    notNeedProcessData.add(sourceRecord);
                }
            });
            service.updateBatchById(notNeedProcessData); // while循环结束,更新未匹配成功,即不需要加工的记录状态为NOT_NEED
            if (!CountDownManager.await(5, TimeUnit.MINUTES)) { // while每循环一次,主线程等待一次,计数器为0时,继续下次while
                logTaskService.updateErrorById(logTask.getTaskId());
                throw new ServiceException(taskName.getCode(), "任务执行等待超时...");
            }
        }
        logTaskService.updateSuccessById(logTask.getTaskId());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.creditMachiningList.add((Machining) applicationContext.getBean("X2Machining"));

        // CL1/CL2业务多于D2/D3,减少判断次数
        this.loanMachiningList.add((Machining) applicationContext.getBean("CL1Machining"));
        this.loanMachiningList.add((Machining) applicationContext.getBean("D2Machining"));

        this.loanAfterMachiningList.add((Machining) applicationContext.getBean("CL2Machining"));
        this.loanAfterMachiningList.add((Machining) applicationContext.getBean("D3Machining"));
    }

}
