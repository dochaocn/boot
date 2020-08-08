package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  本笔贷款状态
 *
 * @author Dc
 */
public enum LoanStatus {

    NORMAL("1", "正常"),
    OVERDUE("2", "逾期"),
    PAYOFF("3", "结清"),
    REVERT("4", "撤销");

    @Getter
    private String code;
    @Getter
    private String desc;

    private LoanStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static LoanStatus judgeValue(String code) {
        LoanStatus[] values = values();
        for (LoanStatus value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
