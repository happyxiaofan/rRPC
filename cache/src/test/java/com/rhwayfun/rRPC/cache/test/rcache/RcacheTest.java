package com.rhwayfun.rRPC.cache.test.rcache;

import org.junit.Test;

import com.rhwayfun.rRPC.cache.rcache.Rcache;
import com.rhwayfun.rRPC.cache.rcache.RcacheV2;
import com.rhwayfun.rRPC.cache.rcache.RcacheV3;
import com.rhwayfun.rRPC.cache.test.SpringTestCase;

public class RcacheTest extends SpringTestCase {

	private final Rcache<String, String> rcache = new Rcache<String, String>();
	private final RcacheV2<String, String> rcacheV2 = new RcacheV2<String, String>();
	private final RcacheV3<String, String> rcacheV3 = new RcacheV3<String, String>();

	@Test
	public void testRcache() {
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				System.out.println("------thread t1 start------");
				System.out.println("----t1 value：" + rcache.getCache("key", "t1") + "----");
				System.out.println("------thread t1 end------");
			}
		});
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				System.out.println("------thread t2 start------");
				System.out.println("----t2 value：" + rcache.getCache("key", "t2") + "----");
				System.out.println("------thread t2 end------");
			}
		});
		Thread t3 = new Thread(new Runnable() {

			public void run() {
				System.out.println("------thread t3 start------");
				System.out.println("----t3 value：" + rcache.getCache("key", "t3") + "----");
				System.out.println("------thread t3 end------");
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	@Test
	public void testRcacheV2() {
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				System.out.println("------thread t1 start------");
				System.out.println("----t1 value：" + rcacheV2.getCache("key", "t1") + "----");
				System.out.println("------thread t1 end------");
			}
		});
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				System.out.println("------thread t2 start------");
				System.out.println("----t2 value：" + rcacheV2.getCache("key", "t2") + "----");
				System.out.println("------thread t2 end------");
			}
		});
		Thread t3 = new Thread(new Runnable() {

			public void run() {
				System.out.println("------thread t3 start------");
				System.out.println("----t3 value：" + rcacheV2.getCache("key", "t3") + "----");
				System.out.println("------thread t3 end------");
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	@Test
	public void testRcacheV3() {
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				System.out.println("------thread t1 start------");
				System.out.println("----t1 value：" + rcacheV3.getCache("key", "t1") + "----");
				System.out.println("------thread t1 end------");
			}
		});
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				System.out.println("------thread t2 start------");
				System.out.println("----t2 value：" + rcacheV3.getCache("key", "t2") + "----");
				System.out.println("------thread t2 end------");
			}
		});
		Thread t3 = new Thread(new Runnable() {

			public void run() {
				System.out.println("------thread t3 start------");
				System.out.println("----t3 value：" + rcacheV3.getCache("key", "t3") + "----");
				System.out.println("------thread t3 end------");
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
}
