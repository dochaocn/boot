package com.bsb.rps.enums;

import lombok.Getter;

/**
 *  任务执行状态
 *
 * @author Dc
 */
public enum TaskStatus {

    RUNNING("RUNNING", "当前任务执行中"),
    SUCCESS("SUCCESS", "当前任务执行成功"),
    ERROR("ERROR", "当前任务执行失败");

    @Getter
    private String code;
    @Getter
    private String desc;

    private TaskStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static TaskStatus judgeValue(String code) {
        TaskStatus[] values = values();
        for (TaskStatus value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}