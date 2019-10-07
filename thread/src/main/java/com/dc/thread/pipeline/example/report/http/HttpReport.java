package com.dc.thread.pipeline.example.report.http;

import com.dc.thread.pipeline.example.report.ReportType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@Component
public class HttpReport implements ReportType {
    @Resource
    private RestTemplate restTemplate;

    @Override
    public Object execute(Object body, String url){
        ResponseEntity<String> response = restTemplate.postForEntity(url, body, String.class);
        return new ResponseMessage(response.getStatusCode(), response.getBody());
    }

}
