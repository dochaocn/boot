package com.dc.thread.pipeline.example;

import lombok.Data;

import java.util.List;

@Data
public class RequestBody {
    private String url;
    private List<Object> obj;
}
