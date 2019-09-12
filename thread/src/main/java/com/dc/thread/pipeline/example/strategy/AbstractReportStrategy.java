package com.dc.thread.pipeline.example.strategy;

import com.dc.thread.pipeline.example.Pipe;
import com.dc.thread.pipeline.example.SimplePipeline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AbstractReportStrategy {
    @Value("${isAsync}")
    protected boolean isAsync;

    protected final List<Pipe<Object,Object>> stageList = new ArrayList<>();

    @Resource
    protected SimplePipeline<Object, Object> simplePipeline;
    @Resource
    protected Pipe<Object,Object> stageOne;
    @Resource
    protected Pipe<Object,Object> stageTwo;
    @Resource
    protected Pipe<Object,Object> stageThree;
    @Resource
    protected Pipe<Object,Object> stageFour;

    protected void useAsyncOrSync() {
        log.info("执行策略类={}, 执行步骤类={}", this.getClass().getName(), stageList.toString());
        if (isAsync)
            simplePipeline.defineAsyncExecutionSteps(stageList); // 异步并行执行
        else
            simplePipeline.defineSyncExecutionSteps(stageList); // 同步串行执行
    }

    // 判断是否使用此策略
    public abstract boolean isThis(Object object);

    // 执行该策略
    public abstract void execute(Object object);

}
