package com.fdsc.controller;

import com.fdsc.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 登录
 * @author zyb
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Resource
    LoginService loginService;
    @ResponseBody
    @RequestMapping("login")
    public String login(String name, String password) {
        try {
            return loginService.login(name,password);
        } catch (Exception e) {
            e.printStackTrace();
            return "{success:false,msg:'登陆失败'}";
        }
    }
}