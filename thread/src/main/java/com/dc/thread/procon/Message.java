package com.dc.thread.procon;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {
    private Integer messageId;
    private String body;
    private LocalDateTime date;
    private Long sequence;
}
