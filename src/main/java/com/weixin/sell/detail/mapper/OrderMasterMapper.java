package com.weixin.sell.detail.mapper;

import com.weixin.sell.detail.bean.OrderMaster;
import com.weixin.sell.detail.bean.OrderMasterExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OrderMasterMapper {
    int countByExample(OrderMasterExample example);

    int deleteByExample(OrderMasterExample example);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    List<OrderMaster> selectByExample(OrderMasterExample example);

    int updateByExampleSelective(@Param("record") OrderMaster record, @Param("example") OrderMasterExample example);

    int updateByExample(@Param("record") OrderMaster record, @Param("example") OrderMasterExample example);
}