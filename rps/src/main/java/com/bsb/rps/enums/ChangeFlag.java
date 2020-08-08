package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  还款计划变更
 *  (目前特指缩期)
 *
 * @author Dc
 */
public enum ChangeFlag {

    Y("Y", "还款计划发生变更"),
    N("N", "还款计划未变更");

    @Getter
    private String code;
    @Getter
    private String desc;

    private ChangeFlag(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ChangeFlag judgeValue(String code) {
        ChangeFlag[] values = values();
        for (ChangeFlag value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}