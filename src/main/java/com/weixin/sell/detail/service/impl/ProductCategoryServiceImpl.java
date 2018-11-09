package com.weixin.sell.detail.service.impl;

import com.weixin.sell.detail.bean.ProductCategory;
import com.weixin.sell.detail.bean.ProductCategoryExample;
import com.weixin.sell.detail.mapper.ProductCategoryMapper;
import com.weixin.sell.detail.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Override
    public ProductCategory findOne(Integer category) throws Exception {
        ProductCategoryExample example  = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(category);
        List<ProductCategory> productCategories = productCategoryMapper.selectByExample(example);

        return productCategories.get(0);
    }

    @Override
    public List<ProductCategory> findAll() throws Exception {
        ProductCategoryExample example  = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdIsNotNull();
        List<ProductCategory> productCategories = productCategoryMapper.selectByExample(example);
        return productCategories;
    }

    @Override
    public List<ProductCategory> findByCategoryTypein(List<Integer> categoryTypeList) throws Exception {
        return null;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) throws Exception {
       productCategoryMapper.insertSelective(productCategory);
       return null;
    }
}
