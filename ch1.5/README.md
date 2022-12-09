# 1.5 Spring 的数据库编程与声明式事务管理

## 概述

Spring 为开发者提供了 JDBC 模板（org.springframework.jdbc.core.JdbcTemplate），用于代码的简化。但是，在实际应用中，JdbcTemplate 并不常用。这里只简要进行介绍。

数据源 org.springframework.jdbc.datasource.DriverManagerDataSource 类的 driverClassName、url、username、password 等成员指定访问数据库所需的驱动、URL、用户名和密码等访问数据库必须的要素。org.springframework.jdbc.core.JdbcTemplate 类的 dataSource 成员指定该 JdbcTemplate 实例关联的数据源：填入 DriverManagerDataSource 实例即可。事务管理器 org.springframework.jdbc.datasource.DataSourceTransactionManager 的 dataSource 属性亦指定其关联的数据源。

Bean 的 property 子节点中，如需以引用类型方式指定值，则使用 ref 属性，而非 value 属性。

Spring 的声明式事务管理通过 AOP（面向方面编程）实现，其本质是对方法前后进行拦截，在目标方法开始之前创建或加入一个事务，执行目标方法之后根据执行情况提交或回滚事务。声明式事务管理进一步减少了代码量，有利于令业务代码不被污染，方便后期的维护。当然，声明式事务管理应对一些复杂的事务也许不太理想：其最细粒度仅作用到方法级别，而不能像编程进行事务管理那样由方法内的代码片段进行一些细节的控制。如果进行一些变通（如：将进行事务处理的代码单独作为一个方法），或许也能解决问题。Spring 的声明式事务管理可以通过 2 种方法实现：基于 XML，或基于 @Transactional 注解。@Transactional 注解可以标注类（接口）或方法，但 Spring 不建议在接口或接口方法使用该注解。@Transactional 注解的属性可以规定被其标注的类（接口）或方法的一些具体行为。

## 例

本例演示如何通过 Spring 的 JDBC 模板访问 MySQL，并演示声明式事务管理的使用。

本例使用最新的 MySQL Community 8.0.31。在 MySQL Workbench 中，