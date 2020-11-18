package com.mrxianx.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
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

    /**
     * 动态刷新配置文件接口测试
     * @return
     */
    @GetMapping(value = "/refresh/remote/value")
    public String refreshRemoteValue(){
        return remoteKey;
    }


    /**
     * 流量控制接口测试
     * 基于url限流
     * @return
     */
    @GetMapping(value = "/hello")
    @SentinelResource("hello")
    public String hello() {
        return "Hello";
    }



}
