package com.tang.dubbo.demo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tang.dubbo.bean.User;
import com.tang.dubbo.service.DemoService;

public class Consumer {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		context.start();

		DemoService demoService = (DemoService) context.getBean("demoService");
		String hello = demoService.sayHello("tom");
		System.out.println(hello);

		List list = demoService.getUsers();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				User usr=(User)list.get(i);
				System.out.println(usr.toString());
			}
		}
		//System.in.read();
	}

}