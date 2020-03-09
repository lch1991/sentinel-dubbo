package com.seate.order.web;

import api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: sentinel-dubbo
 * @description:
 * @author: lch
 * @create: 2020-03-06 16:27
 **/
@RestController
public class WebController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/web")
    public String web(){
        orderService.createOrder();
        return "success";
    }
}
