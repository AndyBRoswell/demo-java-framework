# 1.3 使用面向方面编程（AOP）以更少的代码量扩展所需功能

## 精华知识

@Aspect 修饰的类，用于对一定范围内的方法进行增强。

@Pointcut 固定地修饰一个本体为空、返回类型为 void 的方法，称为切入点方法。@Pointcut 注解的参数为需要增强的方法的范围。

负责对指定方法进行增强 / 扩展的方法，通常都有一个 JoinPoint 或 ProceedingJoinPoint (extends JoinPoint) 参数。Join point 的意思是程序运行过程中的某个特定的时间点。通过时间点参数可以进行获得被增强方法的相关信息等操作。

@Around，参数为切入点方法的方法名（标识符）。被修饰的方法必须有一个 ProceedingJoinPoint 参数，且返回类型必须为 Object。@Around 修饰的方法，在目标方法（被增强的方法）执行前后分别执行一段代码，实现额外功能。

@Before 参数为切入点方法的方法名。执行被增强的方法之前，先执行 @Before 修饰的方法。

@AfterReturning 参数为切入点方法的方法名。被增强的方法返回之后，执行 @AfterReturning 修饰的方法。

@After 参数为切入点方法的方法名。被增强的方法返回且 @AfterReturning 修饰的方法（如有）执行完毕之后，执行 @After 修饰的方法。

@AfterThrowing 参数为切入点方法的方法名和 Throwable 型参数的参数名。被增强的方法抛出异常后，执行 @AfterThrowing 修饰的方法。

基于这些注解，可以轻松为大量的方法统一在特定的时刻增加诸如日志记录、性能统计、权限检查、事务处理、异常处理等常用功能。相比之下，如果仅使用 OOP（面向对象编程）方法，即便已经封装好了这些常用功能，也需要为每个方法增加调用已封装的各项这些功能的代码，显得较为繁琐。但需要注意，AOP 只是 OOP 的补充，而不能取代 OOP。

有多种方式为各个需要增强的方法增加这些代码。特殊的 Java 编译器和类加载器都可以完成这些代码的插入。AspectJ 框架使用这两种方法。而 Spring AOP 框架则在运行期插入这些增强代码。

上述相关的注解与类名均来自 AspectJ。 

## 例

本例包含接口 test_DAO 及其实现 test_DAO_impl。后者为 @Repository 所修饰。MyAspect 类对 test_DAO 中的三个方法 save, modify 和 delete 进行增强。

运行本例可发现：执行每个增强后的方法的过程及前后，分别执行被如下注解修饰的方法：

@Around（执行调用 ProceedingJoinPoint.proceed() 方法之前的语句）-> @Before -> 被增强的方法本身 -> @AfterReturning -> @After -> @Around（执行调用 ProceedingJoinPoint.proceed() 方法之后的语句）。

注意 Spring XML 文档有新增的节点
```xml
<aop:aspectj-autoproxy/>
```
其中
```xml
xmlns:aop="http://www.springframework.org/schema/aop"
```
