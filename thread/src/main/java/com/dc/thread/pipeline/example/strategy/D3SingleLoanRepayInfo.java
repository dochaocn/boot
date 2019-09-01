package com.dc.thread.pipeline.example.strategy;

import com.dc.thread.pipeline.example.Pipe;
import com.dc.thread.pipeline.example.SimplePipeline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

/**
 * 单笔贷款贷后数据信息（对应数据接口 D3：单笔贷款贷后数据上报接口）
 * 包含如下数据项内容：
 * 请求记录唯一编号,贷款编号,姓名,身份证号码,手机号码,当前还款期数,本期还款状态,本期应还款日,
 * 实际还款时间,本期应还款金额,本期剩余应还款金额,本次还款金额,当前逾期天数,
 * 本期还款状态确认时间,当前逾期总额,贷款余额,本笔贷款状态,信息获取时间戳,数据操作标识
 *
 * @author dc
 */

@Slf4j
@Component
public class D3SingleLoanRepayInfo implements ReportStrategy {
    private SimplePipeline<Object, Object> simplePipeline = new SimplePipeline<>();

    @Resource
    private ExecutorService executorService;
    @Resource
    private Pipe<Object,Object> stageOne;
    @Resource
    private Pipe<Object,Object> stageTwo;

    @Override
    public boolean isThis(Object object) {
        return false;
    }

    @Override
    public void execute(Object object) throws InterruptedException {
        simplePipeline.process(object);
    }

    @PostConstruct
    public void buildStage() {
        simplePipeline
                .addPipe(stageOne, executorService)
                .addPipe(stageTwo, executorService)
                .init();
    }
}
