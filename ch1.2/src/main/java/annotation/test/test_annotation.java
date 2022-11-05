package annotation.test;

import annotation.controller.test_controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_annotation {
	public static void main(String[] args) {
		@SuppressWarnings("resources")
		ApplicationContext app_ctx = new ClassPathXmlApplicationContext("config/application_context.xml");
		test_controller c = (test_controller)app_ctx.getBean("test_controller");
		c.save();
	}
}
