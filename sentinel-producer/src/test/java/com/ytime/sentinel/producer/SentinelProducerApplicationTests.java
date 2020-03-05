package com.ytime.sentinel.producer;

import api.SayHelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SentinelProducerApplicationTests {

    @Autowired
    private SayHelloService sayHelloService;

    @Test
    void contextLoads() {
    }

    @Test
    void say(){
        String name = sayHelloService.say("lch");
        System.out.println(name);
    }

}
