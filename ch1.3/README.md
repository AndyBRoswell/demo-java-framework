# 1.3 使用面向方面编程（AOP）以更少的代码量扩展所需功能

## 概述

@Aspect 修饰的类，用于对一定范围内的方法进行增强。

@Pointcut 固定地修饰一个本体为空、返回类型为 void 的方法，称为切入点方法。@Pointcut 注解的参数为需要增强的方法的范围。

负责对指定方法进行增强 / 扩展的方法，通常都有一个 JoinPoint 或 ProceedingJoinPoint (extends JoinPoint) 参数。Join point 的意思是程序运行过程中的某个特定的时间点。通过时间点参数可以进行获得被增强方法的相关信息等操作。

@Around，参数为切入点方法的方法名（标识符）。被修饰的方法必须有一个 ProceedingJoinPoint 参数，且返回类型必须为 Object。@Around 修饰的方法，在目标方法执行前后分别执行一段代码，实现额外功能。

@Before 参数为切入点方法的方法名。