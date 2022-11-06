package AspectJ.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect //@Aspect 声明一个切面
@Component //©Component让此切面成为Spring容器管理的Bean
public class MyAspect {
	/*
	定义切入点，通知增强哪些方法。
	"execution (* aspect j .dao .*.*(..))"是定义切入点表达式，
	该切入点表达式的意思是匹配aspectj.dao包中任意类的任意方法的执行。
	其中 execution ()是表达式的主体，
	第一个*表示返回类型，使用*代表所有类型；
	aspectj.dao 表示需要匹配的包名，后面第二个*表示类名，使用*代表匹配包中所有的类；
	第三个夫表示方法名，使用*表示所有方法；后 面 (..)表示方法的参数，其中表示任意参数。
	另外，注意第一个*与包名之间有一个空格。
	*/
	@Pointcut("execution(* AspectJ.DAO.*.*(..))")
	private void my_pointcut() {}

	// 前置通知，使用Joinpoint接口作为参数获得目标对象信息
	@Before("my_pointcut()") // 切入点的定义方法
	public void before(JoinPoint p) {
		System.out.println("preposition notification: simulate the privilege control, target class object: " + p.getTarget() + ", methods enhanced: " + p.getSignature().getName());
	}

	// 后置返回通知
	@AfterReturning("my_pointcut()")
	public void after_returning(JoinPoint p) {
		System.out.println("postposition return notification: simulate the deletion of temporary files, methods enhanced: " + p.getSignature().getName());
	}

	// 环绕通知
	@Around("my_pointcut()")
	public Object around(ProceedingJoinPoint p) throws Throwable {
		System.out.println("Surround begins: Before the execution of the target method, simulate the opening of the transaction");
		Object obj = p.proceed();
		System.out.println("Surround ends: After the execution of the target method, simulate the closing of the transaction");
		return obj;
	}

	// 异常通知
	@AfterThrowing(value = "my_pointcut()", throwing = "e")
	public void except(Throwable e) {
		System.out.println("Exception notification: The program executed exceptionally: " + e.getMessage());
	}

	// 后置（最终）通知
	@After("my_pointcut()")
	public void after() {
		System.out.println("Final notification: Simulate the release of resources");
	}
}
