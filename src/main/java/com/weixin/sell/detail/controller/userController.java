package com.weixin.sell.detail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class userController {
    @RequestMapping(value="/hello")
    public String hello(HttpServletRequest request){
        System.out.print("123");
        return "/login";
    }
}
