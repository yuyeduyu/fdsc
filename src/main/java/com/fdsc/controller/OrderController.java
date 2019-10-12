package com.fdsc.controller;

import com.fdsc.service.LoginService;
import com.fdsc.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 订单
 * @author zyb
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;
    @ResponseBody
    @RequestMapping("/findOrderByColor")
    public String findOrderByColor(String color) {
        try {
            return orderService.findOrderByColor("%"+color+"%");
        } catch (Exception e) {
            e.printStackTrace();
            return "{success:false,msg:'获取失败'}";
        }
    }
}