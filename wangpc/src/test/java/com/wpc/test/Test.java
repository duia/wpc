package com.wpc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wpc.admin.entity.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:config/applicationContextTest.xml");
		User user = (User) ac.getBean("a");
		System.out.println(user);
	}

}
