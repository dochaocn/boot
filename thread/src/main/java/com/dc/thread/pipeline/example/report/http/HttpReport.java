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
    public boolean isType(Object object) {
        return "http".equals(object);
    }

    @Override
    public Object execute(Object body, String url){
        ResponseEntity<Object> response = restTemplate.postForEntity(url, body, Object.class);
        log.info(response.toString());
        return new ResponseMessage(response.getStatusCode(), response.getBody());
    }

}
