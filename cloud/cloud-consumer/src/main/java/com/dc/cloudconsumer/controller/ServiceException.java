package com.dc.cloudconsumer.controller;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 6514891174875747380L;

    private String code;
    private String msg;
    private Exception exception;

}