package com.dc.thread.pipeline.example.stage;

import com.dc.thread.pipeline.example.controller.RequestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")
public class StageFour extends AbstractPipe {

    @Override
    public Object doProcess(Object input) {
        try {
            Thread.sleep(30);
            int sum = 0;
            for (int i = 0; i < 55555555; i++) {
                sum = sum + i;
            }
        } catch (InterruptedException e) {
            log.error("", e);
        }
        log.info("StageFour:" + input.toString());
        RequestController.countDown();
        return "StageFour-" + input.toString();
    }

}
