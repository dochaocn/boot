package com.dc.thread.pipeline.example.stage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
@Scope("prototype")
public class StageDiff extends AbstractPipe{

    @Resource
    protected AbstractPipe<Object,Object> stageFour;

    @Override
    public Object doProcess(Object input) {
        try {
            stageFour.doProcess(input);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            log.error("", e);
        }
        log.info("StageFour:" + input.toString());
        return "StageFour-" + input.toString();
    }
}
