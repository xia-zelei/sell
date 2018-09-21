package com.weixin.sell;

import com.weixin.sell.detail.bean.OrderDetail;
import com.weixin.sell.detail.service.OrderDetatlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellApplicationTests {

	@Autowired
    OrderDetatlService orderDetatlService;

	@Test
	public void contextLoads() {
		try {

			List<OrderDetail> list = orderDetatlService.findDetailList();
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					System.out.print("id: " + list.get(i).getDetailId() + list.get(i).getUpdateTime());
				}
			}else{
				System.out.print("未查询到数据");
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			System.out.print("错误");
		}
	}

}
