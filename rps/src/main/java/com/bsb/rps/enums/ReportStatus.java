package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  报文处理状态
 *
 * @author Dc
 */
public enum ReportStatus {

    UNREPORTED("0", "未上报记录"),
    REPORTED("1", "已上报记录"),
    ERROR("2", "错误记录");

    @Getter
    private String code;
    @Getter
    private String desc;

    private ReportStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ReportStatus judgeValue(String code) {
        ReportStatus[] values = values();
        for (ReportStatus value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}