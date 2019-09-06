package com.dc.thread.pipeline.example.service.impl;

import com.dc.thread.pipeline.example.RequestBody;
import com.dc.thread.pipeline.example.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseInfoServiceImpl implements BaseInfoService {

    @Value("${D2.url}")
    private String url;

    @Override
    public RequestBody selectBaseInfo(Object object) {
        RequestBody requestBody = new RequestBody();
        List<Object> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        requestBody.setObj(list);
        requestBody.setUrl(url);
        return requestBody;
    }
}
