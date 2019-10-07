package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  本期还款状态
 *
 * @author Dc
 */
public enum TermStatus {

    NORMAL("normal", "本期还款正常"),
    OVERDUE("overdue", "本期还款逾期");

    @Getter
    private String code;
    @Getter
    private String desc;

    private TermStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static TermStatus judgeValue(String code) {
        TermStatus[] values = values();
        for (TermStatus value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
