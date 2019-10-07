package com.bsb.rps.enums;

import lombok.Getter;

/**
 * 当前贷款所处的上报状态
 * 对应 bh_report_plan中 PLAN_REPORT_STATUS字段
 *
 * @author Dc
 */
public enum PlanReportStatus {

    NORMAL("1", "正常上报"),
    OVERDUE("2", "整笔到期逾期"),
    PAYOFF("3", "结清上报完成");

    @Getter
    private String code;
    @Getter
    private String desc;

    private PlanReportStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static PlanReportStatus judgeValue(String code) {
        PlanReportStatus[] values = values();
        for (PlanReportStatus value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
