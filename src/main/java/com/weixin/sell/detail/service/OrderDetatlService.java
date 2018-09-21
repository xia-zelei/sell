package com.weixin.sell.detail.service;

import com.weixin.sell.detail.bean.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface OrderDetatlService extends JpaRepository<OrderDetail,Integer> {
    //查询
    List<OrderDetail> findDetailList()throws Exception;
    OrderDetail findOne(String id)throws Exception;

}
