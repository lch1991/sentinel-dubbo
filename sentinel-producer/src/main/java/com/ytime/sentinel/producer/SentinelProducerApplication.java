package com.ytime.sentinel.producer;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static sun.security.x509.X509CertInfo.KEY;

@SpringBootApplication
@EnableDubboConfig
@DubboComponentScan("com.ytime.sentinel.producer.impl")
public class SentinelProducerApplication {

    public static void main(String[] args) {
        initFlowRule();
        SpringApplication.run(SentinelProducerApplication.class, args);
    }

    private static void initFlowRule() {
        List<FlowRule> list = new ArrayList<>();
        FlowRule rule = new FlowRule();
        //针对具体的方法限流
//        flowRule.setResource("api.SayHelloService:say(java.lang.String)");
        rule.setResource("say");
        rule.setCount(2);//限流阈值 qps=10
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);//限流阈值类型（QPS 或并发线程数）
        rule.setLimitApp(RuleConstant.LIMIT_APP_DEFAULT);//流控针对的调用来源，若为 default 则不区分调用来源
        // 流量控制手段（直接拒绝、Warm Up、匀速排队）
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
        list.add(rule);
        FlowRuleManager.loadRules(list);
    }

}
