package com.weixin.sell.detail.service.impl;

import com.weixin.sell.detail.bean.ProductInfo;
import com.weixin.sell.detail.bean.ProductInfoExample;
import com.weixin.sell.detail.mapper.ProductInfoMapper;
import com.weixin.sell.detail.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ProductInfoService")
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    ProductInfoMapper productInfoMapper;
    @Override
    public List<ProductInfo> findAll() throws Exception {
        ProductInfoExample example = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdIsNotNull();
        List<ProductInfo> productInfoList = productInfoMapper.selectByExample(example);
        return  productInfoList;
    }

    @Override
    public ProductInfo findOne(Integer category) throws Exception {
        ProductInfoExample example = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdEqualTo(String.valueOf(category));
        List<ProductInfo> productInfos = productInfoMapper.selectByExample(example);
        return  productInfos.get(0);
    }

    @Override
    public List<ProductInfo> findByCategoryTypein(List<Integer> categoryTypeList) throws Exception {
        ProductInfoExample example = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryTypeIn(categoryTypeList);
        List<ProductInfo> productInfos = productInfoMapper.selectByExample(example);

        return productInfos;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) throws Exception {
        productInfoMapper.insertSelective(productInfo);
        return null;
    }

}
