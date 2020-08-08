package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  报文处理状态
 *
 * @author Dc
 */
public enum ProcessStatus {

    UNPROCESSED("0", "未处理"),
    PROCESSED("1", "已处理"),
    NOT_NEED("2", "不需要处理");

    @Getter
    private String code;
    @Getter
    private String desc;

    private ProcessStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ProcessStatus judgeValue(String code) {
        ProcessStatus[] values = values();
        for (ProcessStatus value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}