package com.ytime.sentinel.consumers.web;

import api.SayHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: sentinel-dubbo
 * @description:
 * @author: lch
 * @create: 2020-03-04 14:16
 **/
@RestController
public class SayHeoolController {

    @Reference(version = "1.0.0")
    private SayHelloService sayHelloService;

    @RequestMapping("/say")
    public String say(){
        String str = sayHelloService.say("lch");
        return str;
    }

    @RequestMapping("/say1")
    public String say1(){
        String str = sayHelloService.say1("admin");
        return str;
    }
}
