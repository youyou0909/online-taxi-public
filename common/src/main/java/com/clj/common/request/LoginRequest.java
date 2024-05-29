package com.clj.common.request;

import lombok.Data;

/**
 * @Author clj
 * @create 2024/5/29 15:21
 */
@Data
public class LoginRequest {
    private String phoneNumber;
    private String verify;
}
