package com.zhaoya.kafka;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

import com.zhaoya.domain.Car;
import com.zhaoya.service.CarService;

@Component
@EnableKafka
public class CarConsumer implements MessageListener<String, String>{

	@Autowired
	private CarService carService;
	
	@Autowired
	private RedisTemplate redisTemplate;
	/**
	 * @KafkaListener 监听队列
	 */
	@Override
	@KafkaListener(topics= {"GoodsTopic"})
	public void onMessage(ConsumerRecord<String, String> data) {
		// TODO Auto-generated method stub
		String redisKey = data.value();
		
		List<Car> list=redisTemplate.opsForList().range(redisKey, 0, -1);
		
		System.out.println("保存list到mysql");
	}
	
	
}
