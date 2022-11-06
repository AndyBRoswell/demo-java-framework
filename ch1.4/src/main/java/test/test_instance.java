package test;

import instance.bean_class;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_instance {
	public static void main(String[] args) {
		@SuppressWarnings("resources")
		ApplicationContext app_ctx = new ClassPathXmlApplicationContext("config/application_context.xml");
		bean_class b1 = (bean_class)app_ctx.getBean("constructor_instance");
		System.out.println(b1 + "\t\t" + b1.message);
		bean_class b2 = (bean_class)app_ctx.getBean("static_factory_instance");
		System.out.println(b2 + "\t\t" + b2.message);
		bean_class b3 = (bean_class)app_ctx.getBean("instance_factory_instance");
		System.out.println(b3 + "\t\t" + b3.message);
	}
}
