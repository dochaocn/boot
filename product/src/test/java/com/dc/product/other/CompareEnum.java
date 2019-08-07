package com.dc.product.other;

public enum CompareEnum {
    ONE("1","one"), // ordinal 为定义顺序,从0开始累加; name 为定义的名称
    TWO,
    THR;

    CompareEnum() {
    }

    CompareEnum(String code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public static CompareEnum judgeValue(String code){
        CompareEnum[] stauts = CompareEnum.values();
        for(CompareEnum staut : stauts){
            if(staut.getCode().equals(code)){
                return staut;
            }
        }
        return null;
    }
}
