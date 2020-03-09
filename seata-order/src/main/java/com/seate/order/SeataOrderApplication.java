package com.seate.order;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;



@SpringBootApplication(exclude={DruidDataSourceAutoConfigure.class})
@MapperScan("com.sentinel.dao.dao")
@ComponentScan(basePackages = {"com.seate.order","com.sentinel.dao.*","com.sentinel.dao.dao"})
@EnableDubboConfig
@DubboComponentScan("com.seate.order.impl")
public class SeataOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderApplication.class, args);
    }

}
