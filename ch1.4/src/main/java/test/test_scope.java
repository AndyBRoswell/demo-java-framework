package test;

import instance.bean_class;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_scope {
	public static void main(String[] args) {
		@SuppressWarnings("resources")
		ApplicationContext app_ctx = new ClassPathXmlApplicationContext("config/application_context.xml");
		bean_class b1_1 = (bean_class)app_ctx.getBean("singleton-scope");
		System.out.println(b1_1);
		bean_class b1_2 = (bean_class)app_ctx.getBean("singleton-scope");
		System.out.println(b1_2);
		bean_class b2_1 = (bean_class)app_ctx.getBean("prototype-scope");
		System.out.println(b2_1);
		bean_class b2_2 = (bean_class)app_ctx.getBean("prototype-scope");
		System.out.println(b2_2);
	}
}
