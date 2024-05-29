package com.clj.apipassenger.controller;

import com.clj.apipassenger.remote.ServiceVerificationCodeClient;
import com.clj.common.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author clj
 * @create 2024/5/28 09:16
 */
@RestController
public class VerificationCodeController {

    private final String verificationcodePrefix = "passenger-verificationcode-";

    @Autowired
    ServiceVerificationCodeClient serviceVerificationCodeClient;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/verification-code")
    public ResponseResult getVirificationCode(@RequestBody String userPhone){
        System.out.println(userPhone);
        // 调用service-virificationcode服务 获取验证码
        ResponseResult numberCodeResult = serviceVerificationCodeClient.getNumberCode();
        System.out.println("返回的验证码：" + numberCodeResult.getData());
        // 存入redis中
        String key = verificationcodePrefix + userPhone;
        stringRedisTemplate.opsForValue().set(key,numberCodeResult.getData() + "",2, TimeUnit.MINUTES);

        // 发送短信
        return ResponseResult.success(numberCodeResult.getData());
    }
}
