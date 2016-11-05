package com.wpc.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.wpc.admin.entity.User;
import com.wpc.test.spring.MyEvent;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ConfigurableListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/applicationContextTest.xml"));
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:config/applicationContextTest.xml");
//		BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) bf.getBean("bfpp");
//		bfpp.postProcessBeanFactory(bf);
		MyEvent me = new MyEvent("Hello", "msg123");
		ac.publishEvent(me);
		User user = (User) ac.getBean("a");
		System.out.println(user);
	}

}
