package com.dc.thread.pipeline.example.strategy;

import com.dc.thread.pipeline.example.SimplePipeline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AbstractReportStrategy {
    @Value("${processType}")
    protected String processType;

    protected final List<String> stageList = new ArrayList<>();

    @Resource
    protected SimplePipeline<Object, Object> simplePipeline;

    protected void useAsyncOrSync() {
        log.info("执行策略类={}, 执行步骤类={}", this.getClass().getName(), stageList.toString());
        if ("PipeAsync".equals(processType)){
            simplePipeline.definePipeLineAsyncSteps(stageList);
        } else if ("SimpleAsync".equals(processType) || "Sync".equals(processType)) {
            simplePipeline.defineSimpleAsyncSteps(stageList);
        }
    }

    // 判断是否使用此策略
    public abstract boolean isThis(Object object);

    // 执行该策略
    public void execute(Object object) {
        simplePipeline.process(object, processType);
    }

}
