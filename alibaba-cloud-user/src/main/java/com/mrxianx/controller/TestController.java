package com.mrxianx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author XianXiong
 * @Date 2020/11/18
 * @Version 1.0
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${remote.key}")
    private String remoteKey;

    @GetMapping(value = "/refresh/remote/value")
    public String refreshRemoteValue(){
        return remoteKey;
    }

}
