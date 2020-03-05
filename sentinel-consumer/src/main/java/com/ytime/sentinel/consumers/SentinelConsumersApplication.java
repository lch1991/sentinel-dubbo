package com.ytime.sentinel.consumers;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfig
@DubboComponentScan("com.ytime.sentinel.consumers.web")
public class SentinelConsumersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelConsumersApplication.class, args);
    }

}
