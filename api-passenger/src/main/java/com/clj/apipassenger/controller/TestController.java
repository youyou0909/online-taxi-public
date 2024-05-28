package com.clj.apipassenger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author clj
 * @create 2024/5/28 09:02
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "api-passenger";
    }
}
