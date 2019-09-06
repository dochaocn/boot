package com.dc.thread.pipeline.example.report.http;

import com.dc.thread.pipeline.example.report.ReportType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

@Slf4j
@Component
public class HttpReport implements ReportType {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private ExecutorService executorService;

    @Override
    public boolean isType(Object object) {
        return "http".equals(object);
    }

    @Override
    public Object execute(Object body, String url){

        try {
            return executorService.submit(() -> {
                ResponseEntity<Object> response = restTemplate.postForEntity(url, body, Object.class);
                log.info(response.toString());
                return new ResponseMessage(response.getStatusCode(), response.getBody());
            }).get();
        } catch (Exception e) {
            log.error("http请求错误", e);
            return null;
        }
    }

}
