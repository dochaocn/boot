package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  产品当前上报状态
 *  对应 bh_sys_prod中 REPORT_STATUS字段
 *
 * @author Dc
 */
public enum  ProdReportStatus {

    EFFECT("0", "生效中"),
    INVALID("1", "已失效");

    @Getter
    private String code;
    @Getter
    private String desc;

    private ProdReportStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ProdReportStatus judgeValue(String code) {
        ProdReportStatus[] values = values();
        for (ProdReportStatus value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
