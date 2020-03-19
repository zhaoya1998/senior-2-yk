package com.zhaoya.service.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTest {
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		/** opsForValue().set 可以保存对象，也也可以保存List**/
		redisTemplate.opsForValue().set("test", "test reids ");
		Object object = redisTemplate.opsForValue().get("test");
		List<Object> list = new ArrayList();
		redisTemplate.opsForList().leftPush("list",list);
//		redisTemplate.opsForList().range(key, start, end);
		System.out.println(object);
		
		/** 设置缓存的Key **/
		String cacheKey = "1710fhotlist:1";
	}
}
