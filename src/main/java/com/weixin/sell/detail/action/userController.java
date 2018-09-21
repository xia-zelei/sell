package com.weixin.sell.detail.action;

import com.weixin.sell.detail.bean.OrderDetail;
import com.weixin.sell.detail.service.OrderDetatlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class userController {
    @Autowired
    OrderDetatlService orderDetatlService;

    @RequestMapping(value="/hello")
    public String hello(HttpServletRequest request)throws Exception{
        System.out.print("123");
        return "login";
    }

    @RequestMapping(value="/orderid")
    public String findOne()throws Exception{
        OrderDetail orderDetail =  orderDetatlService.findOne("1");
        return  orderDetail.getProductName();
    }
}
