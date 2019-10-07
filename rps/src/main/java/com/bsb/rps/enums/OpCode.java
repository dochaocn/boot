package com.bsb.rps.enums;

import lombok.Getter;

public enum  OpCode {

    NEW_RECORD("A", "新纪录"),
    CHG_RECORD("M", "修改记录");

    @Getter
    private String code;
    @Getter
    private String desc;

    private OpCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static OpCode judgeValue(String code) {
        OpCode[] values = values();
        for (OpCode value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
