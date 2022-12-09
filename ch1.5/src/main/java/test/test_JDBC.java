package test;

import service.service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_JDBC {
	public static void main(String[] args) {
		@SuppressWarnings("resources") final ApplicationContext app_ctx = new ClassPathXmlApplicationContext("application-context.xml");
		final var test_service = (service)app_ctx.getBean("test_service_impl");
		test_service.test_JDBC();
		final var test_service_tx = (service)app_ctx.getBean("test_service_impl_tx");
		test_service_tx.test_JDBC();
	}
}
