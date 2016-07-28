package com.rhwayfun.common.test.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rhwayfun.common.test.SpringTestCase;
import com.rhwayfun.rRPC.service.RedisTestService;

public class RedisTestServiceTest extends SpringTestCase {

	@Autowired
	private RedisTestService redisTestService;
	
	@Test
	public void testGetTimeStamp() throws InterruptedException{
		System.out.println("第一次调用：" + redisTestService.getTimeStamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + redisTestService.getTimeStamp("param"));
        Thread.sleep(11000);
        System.out.println("再过11秒之后调用：" + redisTestService.getTimeStamp("param"));
	}
}
