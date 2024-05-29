package com.clj.apipassenger.controller;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.clj.apipassenger.bean.PassengerBean;
import com.clj.apipassenger.mapper.PassengerMapper;
import com.clj.apipassenger.service.LoginService;
import com.clj.common.constants.CommonStatusEnum;
import com.clj.common.constants.VerifycodeConstants;
import com.clj.common.request.LoginRequest;
import com.clj.common.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author clj
 * @create 2024/5/29 15:20
 */
@RestController
public class LoginController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    LoginService loginService;


    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginRequest request){
        String phoneNumber = request.getPhoneNumber();
        String verify = request.getVerify();
        //验证 验证码
        String key = VerifycodeConstants.verificationcodePrefix + phoneNumber;
        String verifyRedis = stringRedisTemplate.opsForValue().get(key); // Redis中存的验证码
        if ((!StringUtils.isBlank(verify)) && verify.equals(verifyRedis)){// 验证码通过
            // 查询乘客表 如果已经存在 则登录成功 如果不存在 进行存储 然后返回登录成功
            boolean b = loginService.passengerIsExsits(phoneNumber);
            if (!b){
                PassengerBean passengerBean = new PassengerBean();
                passengerBean.setPhone(phoneNumber);
                passengerBean.setCreateDtm(new Date());
                passengerBean.setUpdateDtm(new Date());
                int i = loginService.insertPassenger(passengerBean);
                System.out.println("插入乘客结果 ：" + i);
            }
            return ResponseResult.success("");
        }else {
            return ResponseResult.fail(CommonStatusEnum.VERIFYCODE_ERROR.getCode(), CommonStatusEnum.VERIFYCODE_ERROR.getValue());
        }
    }

}
