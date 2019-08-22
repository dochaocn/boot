package com.dc.cloudconsumer.response;

import lombok.Getter;

@Getter
public enum ResponseStatus {

    SUCCESS("200", "成功"),
    ERROR("500", "失败");

    private String code;
    private String desc;

    ResponseStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
