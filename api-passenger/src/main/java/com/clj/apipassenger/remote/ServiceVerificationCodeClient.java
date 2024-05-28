package com.clj.apipassenger.remote;

import com.clj.common.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author clj
 * @create 2024/5/28 10:38
 */
@FeignClient("service-verificationcode")
public interface ServiceVerificationCodeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/numberCode/6")
    ResponseResult getNumberCode();
}
