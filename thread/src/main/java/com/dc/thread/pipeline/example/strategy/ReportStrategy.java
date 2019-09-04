package com.dc.thread.pipeline.example.strategy;

public interface ReportStrategy {

    // 判断是否使用此策略
    boolean isThis(Object object);

    // 执行该策略
    void execute(Object object);

}
