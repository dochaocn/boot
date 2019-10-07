package com.bsb.rps.dto;

import com.bsb.rps.entity.BhReportPlan;
import com.bsb.rps.enums.ReportType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class MachiningRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String flowNo;
    private String custNo;
    private ReportType reportType;
    private Object sourceRecord; // 全量表或上报计划中的源数据
    private Object targetRecord; // 加工完成的报文数据
    private BhReportPlan reportPlan; // 加工完成,维护上报计划表

}