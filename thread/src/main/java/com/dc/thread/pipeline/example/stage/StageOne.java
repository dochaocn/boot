package com.dc.thread.pipeline.example.stage;

import com.dc.thread.pipeline.example.AbstractPipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StageOne extends AbstractPipe<Object, Object> {

    @Override
    public Object doProcess(Object input) throws InterruptedException {
        // 第一步，判断是否需要上报
        Thread.sleep(50L);
        log.info("StageOne:" + input.toString());
        // 第二步，确认使用哪种上报类型

        return "StageOne-" + input.toString();
    }
}
