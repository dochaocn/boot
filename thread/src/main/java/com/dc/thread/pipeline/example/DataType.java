package com.dc.thread.pipeline.example;

public enum DataType {

    D2("#singleLoanAccountInfo", "非循环贷款账户数据信息"),
    D3("#singleLoanRepayInfo", "非循环贷款贷后数据信息"),
    X2("#loopLoanAccountInfo", "循环贷款账户数据信息"),
    CL1("#loopLoanReceiptInfo", "循环贷款合并账单数据信息"),
    CL2("#loopLoanReceiptRepayInfo", "循环贷款合并账单还款数据信息");

    DataType(String code, String desc) {
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

    public static DataType judgeValue(String code){
        for(DataType status : DataType.values()){
            if(status.getCode().equals(code)){
                return status;
            }
        }
        return null;
    }


}
