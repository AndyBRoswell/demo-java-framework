package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.MyService;

public class test_init_and_destroy {
	public static void main(String[] args) {
		@SuppressWarnings("resources")
		ClassPathXmlApplicationContext app_ctx = new ClassPathXmlApplicationContext("config/application_context.xml");
		System.out.println("Before getting the object");
		MyService life = (MyService)app_ctx.getBean("life");
		System.out.println("After getting the object: " + life);
		app_ctx.close();
	}
}
