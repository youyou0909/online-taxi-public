package com.clj.verificationcode.controller;

import com.clj.common.response.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author clj
 * @create 2024/5/28 13:25
 */
@RestController

public class VerificationcodeController {

    @GetMapping("/numberCode/{size}")
    public ResponseResult getNumberCode(@PathVariable("size") int size){

        double v = ((Math.random() * 9) + 1) * (Math.pow(10, size - 1));
        int num = (int) v;
        System.out.println("生成的验证码：" + num + "");
        return ResponseResult.success(num + "");
    }

    public static void main(String[] args) {
        double random = Math.random();
        System.out.println(random);
        System.out.println((int)((random * 9 + 1) * (Math.pow(10,6-1))));
        System.out.println((random * 9 + 1) * (Math.pow(10,6-1)));
    }
}
