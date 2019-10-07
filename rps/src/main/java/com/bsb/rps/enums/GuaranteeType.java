package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  贷款担保类型
 *
 * @author Dc
 */
public enum  GuaranteeType {

    XIN_YONG("1", "信用"),
    DI_YA("2", "抵押"),
    ZHI_YA("3", "质押"),
    BAO_ZHENG("4", "保证"),
    ZU_HE("5", "组合"),
    QI_TA("6", "其他");

    @Getter
    private String code;
    @Getter
    private String desc;

    private GuaranteeType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static GuaranteeType judgeValue(String code) {
        GuaranteeType[] values = values();
        for (GuaranteeType value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
