package com.dc.thread.pipeline.example.report;

public interface ReportType {

    boolean isType(Object object);

    Object execute(Object body, String url);
}
