package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  任务执行状态
 *
 * @author Dc
 */
public enum TaskName {

    IMPORT("Import", "更新全量表"),
    CREDIT("Credit", "加工授信开立/变更数据"),
    LOAN("Loan", "加工借据开立/变更数据"),
    LOAN_AFTER_HAS_REPAY("LoanAfterHasRepayFlow", "加工贷后数据(有还款)"),
    LOAN_AFTER_NOT_REPAY("LoanAfterNotRepayFlow", "加工贷后数据(无还款)");

    @Getter
    private String code;
    @Getter
    private String desc;

    private TaskName(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static TaskName judgeValue(String code) {
        TaskName[] values = values();
        for (TaskName value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}