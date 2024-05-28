package com.clj.common.constants;

import lombok.Getter;

/**
 * @Author clj
 * @create 2024/5/28 09:41
 */

public enum CommonStatusEnum {
    SUCCESS(1,"success"),
    FAIL(0,"fail")
    ;
    @Getter
    private int code;
    @Getter
    private String value;

    CommonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
