package com.weixin.sell.detail.service.impl;

import com.weixin.sell.detail.bean.ProductCategory;
import com.weixin.sell.detail.bean.ProductCategoryExample;
import com.weixin.sell.detail.mapper.ProductCategoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductCategoryServiceImplTest {
    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Test
    public void findOne() throws Exception {

    }

    @Test
    public void findAll() throws Exception {
        ProductCategoryExample example  = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdIsNotNull();

        List<ProductCategory> productCategories = productCategoryMapper.selectByExample(example);
        for (ProductCategory productCategory: productCategories){
            Integer categoryType = productCategory.getCategoryType();
            String categoryName = productCategory.getCategoryName();
            System.out.print("类型"+categoryType+ "  :名称"+categoryName);

        }
    }

    @Test
    public void findByCategoryTypein() throws Exception {
    }

    @Test
    public void save() throws Exception {
    }

}