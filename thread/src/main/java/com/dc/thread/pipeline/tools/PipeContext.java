package com.dc.thread.pipeline.tools;


import lombok.extern.slf4j.Slf4j;

/**
 * 对各个处理阶段的计算环境进行抽象，主要用于异常处理
 * @author huzhiqiang
 */
@Slf4j
public class PipeContext {

    private final static PipeContext pipeContext = new PipeContext();

    private PipeContext() {
    }

    public static PipeContext newDefaultPipeContext(){
        return pipeContext;
    }

    public static void handleError(Exception e) {
        log.error("", e);
    }
}