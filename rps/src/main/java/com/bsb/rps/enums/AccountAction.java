package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  授信账户操作代码
 *
 * @author Dc
 */
public enum AccountAction {

    OPEN_ACCOUNT("1", "开立新账户"),
    CHANGE_ACCOUNT("2", "变更账户信息或状态");

    @Getter
    private String code;
    @Getter
    private String desc;

    private AccountAction(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AccountAction judgeValue(String code) {
        AccountAction[] values = values();
        for (AccountAction value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
