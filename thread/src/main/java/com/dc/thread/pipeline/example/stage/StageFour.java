package com.dc.thread.pipeline.example.stage;

import com.dc.thread.pipeline.example.AbstractPipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StageFour extends AbstractPipe {

    @Override
    public Object doProcess(Object input) throws InterruptedException {
        Thread.sleep(50L);
        log.info("StageFour:" + input.toString());
        return "StageFour-" + input.toString();
    }

}
