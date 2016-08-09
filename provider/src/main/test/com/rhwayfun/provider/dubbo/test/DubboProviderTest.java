package com.rhwayfun.provider.dubbo.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboProviderTest {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-provider.xml"});
		ctx.start();
		System.out.println("服务暴露成功！");
		// 按任意键退出
		System.in.read();
	}
}
