package com.dc.thread.pipeline.example.stage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StageThree extends AbstractPipe {

    @Override
    public Object doProcess(Object input) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            log.error("", e);
        }
//        log.info("StageThree:" + input.toString());
        return "StageThree-" + input.toString();
    }
}
