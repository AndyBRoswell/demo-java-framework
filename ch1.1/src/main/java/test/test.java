package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import DAO.test_DAO;

public class test {
	public static void main(String[] args) {
		@SuppressWarnings("resources") //@SuppressWarnings抑制警告的关键字，有泛型未指定类型
		//初始化Spring容器Applicationcontext,加载配置文件
		ApplicationContext app_ctx = new ClassPathXmlApplicationContext("config/application_context.xml"); //通过容器获取test实例
		test_DAO t = (test_DAO) app_ctx.getBean("test"); //test 为酉己置文件中的 id
		t.say_Hello();
	}
}
