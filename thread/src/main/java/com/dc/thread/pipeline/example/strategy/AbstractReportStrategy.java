package com.dc.thread.pipeline.example.strategy;

import com.dc.thread.pipeline.example.Pipe;
import com.dc.thread.pipeline.example.SimplePipeline;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractReportStrategy implements ReportStrategy {
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
        if (isAsync)
            simplePipeline.defineAsyncExecutionSteps(stageList); // 异步并行执行
        else
            simplePipeline.defineSyncExecutionSteps(stageList); // 同步串行执行
    }
}
