package com.zhaoya.service.impl.test;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zhaoya.domain.Car;
import com.zhaoya.domain.Vo;
import com.zhaoya.service.CarService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class CarTests {

	@Autowired
	private CarService carService;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Test
	public void syncArticleToKafka() {
		for (int pageNum = 1; pageNum < 1000; pageNum++) {
			/** 分页查询数据 **/
			Vo vo = null;
			List<Car> carList =carService.getGoodsList(vo, pageNum);
			if(carList==null || carList.size()==0) {
				break;
			}
			/** 把商品转化成Json字符串，发送到消息队列（kafka） **/
			for (Car car : carList) {
				/** fastJson把对象转化成字符串 **/
				String carStr = JSON.toJSONString(car);
				kafkaTemplate.send("CarTopic", carStr);
				System.out.println("syncCarToKafka carCid:"+car.getCid());
			}
		}
		/** 生产者发送完数据后，整个测试会停掉，消费者还没有消费完数据。 **/
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
