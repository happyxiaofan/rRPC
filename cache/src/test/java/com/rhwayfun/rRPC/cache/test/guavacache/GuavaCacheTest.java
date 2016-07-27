package com.rhwayfun.rRPC.cache.test.guavacache;

import org.junit.Test;

import com.rhwayfun.rRPC.cache.guava.GuavaCache;
import com.rhwayfun.rRPC.cache.test.SpringTestCase;

public class GuavaCacheTest extends SpringTestCase {

	private GuavaCache<String, String> gcache = new GuavaCache<String, String>();
	
	@Test
	public void testGcache() {
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				System.out.println("------thread t1 start------");
				System.out.println("----t1 value：" + gcache.getCache("key", "t1") + "----");
				System.out.println("------thread t1 end------");
			}
		});
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				System.out.println("------thread t2 start------");
				System.out.println("----t2 value：" + gcache.getCache("key", "t2") + "----");
				System.out.println("------thread t2 end------");
			}
		});
		Thread t3 = new Thread(new Runnable() {

			public void run() {
				System.out.println("------thread t3 start------");
				System.out.println("----t3 value：" + gcache.getCache("key", "t3") + "----");
				System.out.println("------thread t3 end------");
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
}
