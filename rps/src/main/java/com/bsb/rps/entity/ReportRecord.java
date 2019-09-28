package com.bsb.rps.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReportRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private String recordType;

    private Object data;

}
