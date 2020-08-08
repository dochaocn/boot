package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  本期还款计划结清标识
 *
 * @author Dc
 */
public enum PayOffFlag {

    Y("Y", "还款计划当期已结清"),
    N("N", "还款计划当期未结清");

    @Getter
    private String code;
    @Getter
    private String desc;

    private PayOffFlag(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static PayOffFlag judgeValue(String code) {
        PayOffFlag[] values = values();
        for (PayOffFlag value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
