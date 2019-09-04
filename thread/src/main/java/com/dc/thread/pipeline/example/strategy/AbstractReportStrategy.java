package com.dc.thread.pipeline.example.strategy;

import com.dc.thread.pipeline.example.Pipe;
import com.dc.thread.pipeline.example.SimplePipeline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Slf4j
public abstract class AbstractReportStrategy implements ReportStrategy {
    @Value("${isAsync}")
    protected boolean isAsync;

    protected final List<Pipe<Object,Object>> stageList = new ArrayList<>();
    protected final SimplePipeline<Object, Object> simplePipeline = new SimplePipeline<>();

    @Resource
    protected ExecutorService executorService;
    @Resource
    protected Pipe<Object,Object> stageOne;
    @Resource
    protected Pipe<Object,Object> stageTwo;
    @Resource
    protected Pipe<Object,Object> stageThree;
    @Resource
    protected Pipe<Object,Object> stageFour;

    protected void useAsyncOrSync() {
        if (isAsync) {
            // 异步并行执行
            simplePipeline.defineExecutionSteps(stageList, executorService);
        } else {
            // 同步串行执行
            simplePipeline.defineExecutionSteps(stageList);
        }
    }
}
