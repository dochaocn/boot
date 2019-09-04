package com.dc.thread.pipeline.example.stage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StageTwo extends AbstractPipe {

    @Override
    public Object doProcess(Object input) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            log.error("", e);
        }
//        log.info("StageTwo:" + input.toString());
        return "StageTwo-" + input.toString();
    }
}
