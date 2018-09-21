package com.weixin.sell.detail.service;

import com.weixin.sell.detail.bean.OrderDetail;

import java.util.List;

public interface OrderDetatlService {
    //查询
    List<OrderDetail> findDetailList()throws Exception;
    OrderDetail findOne(String id)throws Exception;
}
