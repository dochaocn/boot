package com.dc.thread.pipeline.example.report;

public interface ReportType {

    Object execute(Object body, String url);
}
