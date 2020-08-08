package com.bsb.rps.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class BaseFiled implements Serializable {
    private static final long serialVersionUID = 1L;

    private String reqId;
    private String uploadTs;
    private String processDate;
    private String reportType;
    private String reportStatus;

}
