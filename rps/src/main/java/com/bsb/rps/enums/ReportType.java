package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  上报类型，共计五种
 *
 * @author Dc
 */
public enum ReportType {

    X2("X2", "循环贷款授信"),
    D2("D2", "非循环贷借据开立/变更"),
    D3("D3", "非循环贷贷后"),
    CL1("CL1", "循环贷借据开立/变更"),
    CL2("CL2", "循环贷贷后");

    private ReportType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Getter
    private String code;
    @Getter
    private String desc;

    public static ReportType judgeValue(String code){
        ReportType[] values = ReportType.values();
        for(ReportType value : values){
            if(value.getCode().equals(code)){
                return value;
            }
        }
        return null;
    }
}
