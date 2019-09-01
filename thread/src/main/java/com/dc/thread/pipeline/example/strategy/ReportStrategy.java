package com.dc.thread.pipeline.example.strategy;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

public interface ReportStrategy {

    // 判断是否使用此策略
    boolean isThis(Object object);

    // 执行该策略
    void execute(Object object) throws InterruptedException;

}
