package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  贷款用途
 *
 * @author Dc
 */
public enum LoanPurpose {

    NONE("1", "无场景贷款"),
    JIAO_YU("2", "教育"),
    YI_MEI("3", "医美"),
    ZU_FANG("4", "租房"),
    SHU_MA("5", "数码"),
    MAI_CHE("6", "买车"),
    ZHUANG_XIU("7", "装修"),
    LV_YOU("8", "旅游"),
    NONG_YE("9", "农业生产"),
    JING_YING("10", "企业经营"),
    ZONG_HE("11", "综合用款"),
    GOU_WU("12", "商城购物"),
    XIAO_FEI("13", "日常消费"),
    WEI_ZHI("99", "未知");

    @Getter
    private String code;
    @Getter
    private String desc;

    private LoanPurpose(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static LoanPurpose judgeValue(String code) {
        LoanPurpose[] values = values();
        for (LoanPurpose value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
