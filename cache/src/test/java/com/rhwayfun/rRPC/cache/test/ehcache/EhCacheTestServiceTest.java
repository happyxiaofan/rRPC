package com.rhwayfun.rRPC.cache.test.ehcache;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rhwayfun.rRPC.cache.test.SpringTestCase;
import com.rhwayfun.rRPC.service.EhcacheTestService;

public class EhCacheTestServiceTest extends SpringTestCase {

	@Autowired
	private EhcacheTestService ehcacheTestService;
	
	@Test
	public void testGetTimeStamp() throws InterruptedException{
		System.out.println("第一次调用：" + ehcacheTestService.getTimestamp("param"));
		Thread.sleep(2000);
		System.out.println("第二次调用（2秒后）：" + ehcacheTestService.getTimestamp("param"));
		Thread.sleep(10000);
		System.out.println("第三次调用（10秒后）：" + ehcacheTestService.getTimestamp("param"));
	}
}
