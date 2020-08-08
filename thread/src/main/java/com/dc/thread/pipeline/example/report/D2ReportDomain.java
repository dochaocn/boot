package com.dc.thread.pipeline.example.report;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class D2ReportDomain {
    @Value("${D2.url}")
    private String url;

    private String name;
    private String idNo;
}
