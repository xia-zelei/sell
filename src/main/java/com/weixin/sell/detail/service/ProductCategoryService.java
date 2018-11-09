package com.weixin.sell.detail.service;

import com.weixin.sell.detail.bean.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryService{
    ProductCategory findOne(Integer category)throws Exception;
    List<ProductCategory> findAll()throws Exception;

    List<ProductCategory> findByCategoryTypein(List<Integer> categoryTypeList)throws Exception;
    ProductCategory save(ProductCategory productCategory)throws Exception;

}
