package com.dc.thread.pipeline.example.report.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {
   private HttpStatus httpStatus;
   private Object message;
}
