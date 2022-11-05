package AspectJ.test;

import AspectJ.DAO.test_DAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP {
	public static void main(String[] args) {
		@SuppressWarnings("resources")
		ApplicationContext app_ctx = new ClassPathXmlApplicationContext("AspectJ/config/application_context.xml");
		test_DAO test_DAO_advice = (test_DAO)app_ctx.getBean("test_DAO");
		System.out.println("================================================================");
		test_DAO_advice.save();
		System.out.println("================================================================");
		test_DAO_advice.modify();
		System.out.println("================================================================");
		test_DAO_advice.delete();
		System.out.println("================================================================");
	}
}
