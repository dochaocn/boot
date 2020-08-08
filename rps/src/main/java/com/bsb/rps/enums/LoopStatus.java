package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  是否是循环贷款
 *
 * @author Dc
 */
public enum LoopStatus {

    Y("Y", "循环贷款"),
    N("N", "非循环贷款");

    @Getter
    private String code;
    @Getter
    private String desc;

    private LoopStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static LoopStatus judgeValue(String code) {
        LoopStatus[] values = values();
        for (LoopStatus value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}