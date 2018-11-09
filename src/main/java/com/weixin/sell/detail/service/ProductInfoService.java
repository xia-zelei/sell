package com.weixin.sell.detail.service;

import com.weixin.sell.detail.bean.ProductInfo;

import java.util.List;

public interface ProductInfoService {

    public List<ProductInfo> findAll()throws Exception;
    ProductInfo findOne(Integer category)throws Exception;
    List<ProductInfo> findByCategoryTypein(List<Integer> categoryTypeList)throws Exception;
    ProductInfo save(ProductInfo productInfo)throws Exception;
}
