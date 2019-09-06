package com.dc.thread.pipeline.example.report.file;

import com.dc.thread.pipeline.example.report.ReportType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FileReport implements ReportType {
    @Override
    public boolean isType(Object object) {
        return false;
    }

    @Override
    public Object execute(Object body, String url) {
        return null;
    }

}
