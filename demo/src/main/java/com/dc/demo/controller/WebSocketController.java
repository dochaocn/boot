package com.dc.demo.controller;

import com.dc.demo.dto.WebSocketResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("hello")
    @SendTo("/topic/getResponse")
    public WebSocketResponse hello() {
        WebSocketResponse response = new WebSocketResponse();
        response.setId("1");
        response.setName("response");
        return response;
    }
}
