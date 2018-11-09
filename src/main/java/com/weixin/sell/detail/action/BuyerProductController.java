package com.weixin.sell.detail.action;

import com.weixin.sell.detail.bean.ProductCategory;
import com.weixin.sell.detail.bean.ProductInfo;
import com.weixin.sell.detail.service.ProductCategoryService;
import com.weixin.sell.detail.service.ProductInfoService;
import com.weixin.sell.detail.vo.ProductInfoVo;
import com.weixin.sell.detail.vo.ProductVo;
import com.weixin.sell.detail.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/byyer/product")
public class BuyerProductController {

    @Autowired
    ProductInfoService productInfoService;
    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVo list() throws Exception {

        //1.查询类目(一次性查询)
        List categoryList = new ArrayList();
        List<ProductCategory> productCategoryServiceAll = productCategoryService.findAll();
        for (ProductCategory productCategory: productCategoryServiceAll){
            categoryList.add(productCategory.getCategoryType());
        }
        //2查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findByCategoryTypein(categoryList);

        //3数据拼装
        List<ProductVo> productVoList = new ArrayList<ProductVo>();
        for (ProductCategory productCategory : productCategoryServiceAll){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVo> productInfoVoList = new ArrayList<ProductInfoVo>();

            for (ProductInfo productInfo: productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }

        ResultVo resultVo = new ResultVo();
        resultVo.setCode(1);
        resultVo.setMsg("成功");
        resultVo.setData(productVoList);
        return resultVo;
    }
}
