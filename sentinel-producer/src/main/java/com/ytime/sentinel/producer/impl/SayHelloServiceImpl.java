package com.ytime.sentinel.producer.impl;

import api.SayHelloService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @program: sentinel-dubbo
 * @description:
 * @author: lch
 * @create: 2020-03-04 13:26
 **/
@Service(interfaceClass = SayHelloService.class,version = "1.0.0")
@Component
public class SayHelloServiceImpl implements SayHelloService {

    @SentinelResource(value = "say", blockHandler = "handleFlowQpsException",
            fallback = "querysayFallback")
    @Override
    public String say(String name) {
        return name;
    }

    public String handleFlowQpsException(String name, BlockException e) {
        e.printStackTrace();
        System.out.println("handleFlowQpsException for queryOrderInfo2:" + name);
        return "handleFlowQpsException for queryOrderInfo2: " + name;
    }

    public String querysayFallback(String name, Throwable e) {
        System.out.println("fallback querysayFallback: " + name);
        return "fallback querysayFallback: " + name;
    }

    @Override
    public String say1(String name) {
        return name;
    }
}
