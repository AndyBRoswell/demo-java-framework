# 1.5 Spring 的数据库编程与声明式事务管理

## 概述

Spring 为开发者提供了 JDBC 模板（org.springframework.jdbc.core.JdbcTemplate），用于代码的简化。但是，在实际应用中，JdbcTemplate 并不常用。这里只简要进行介绍。

数据源 org.springframework.jdbc.datasource.DriverManagerDataSource 类的 driverClassName、url、username、password 等成员指定访问数据库所需的驱动、URL、用户名和密码等访问数据库必须的要素。org.springframework.jdbc.core.JdbcTemplate 类的 dataSource 成员指定该 JdbcTemplate 实例关联的数据源：填入 DriverManagerDataSource 实例即可。事务管理器 org.springframework.jdbc.datasource.DataSourceTransactionManager 的 dataSource 属性亦指定其关联的数据源。

JdbcTemplate 类通过 query 方法查询数据库内容，通过 update 方法对数据库进行插入、更新和删除。

Bean 的 property 子节点中，如需以引用类型方式指定值，则使用 ref 属性，而非 value 属性。

Spring 的声明式事务管理通过 AOP（面向方面编程）实现，其本质是对方法前后进行拦截，在目标方法开始之前创建或加入一个事务，执行目标方法之后根据执行情况提交或回滚事务。声明式事务管理进一步减少了代码量，有利于令业务代码不被污染，方便后期的维护。当然，声明式事务管理应对一些复杂的事务也许不太理想：其最细粒度仅作用到方法级别，而不能像编程进行事务管理那样由方法内的代码片段进行一些细节的控制。如果进行一些变通（如：将进行事务处理的代码单独作为一个方法），或许也能解决问题。Spring 的声明式事务管理可以通过 2 种方法实现：基于 XML，或基于 @Transactional 注解。@Transactional 注解可以标注类（接口）或方法，但 Spring 不建议在接口或接口方法使用该注解。@Transactional 注解的属性可以规定被其标注的类（接口）或方法的一些具体行为。

## 例

本例演示如何通过 Spring 的 JDBC 模板访问 MySQL，并演示声明式事务管理的使用。

本例使用最新的 MySQL Community 8.0.31。在 MySQL 中，执行如下语句（可通过 MySQL Workbench 执行）：

```sql
create user 'java-framework-sample-ch1.5' identified by '0';
grant all on * to 'java-framework-sample-ch1.5';
create database spring_test;
use spring_test;
create table user (
	id bigint not null primary key,
    name varchar(32) default '',
    sex varchar(10) default ''
);
```

创建示例用户和测试用表。

本例的 service_impl 和 service_impl_tx 的 test_JDBC 成员方法分别演示不通过和通过 @Transactional 注解调用 DAO_impl 类中的 JdbcTemplate 完成对 MySQL 数据库的访问。演示用的 SQL 语句包括向测试用表 spring_test.user 中添加若干用户信息并查询整张表已有的用户信息，最后删除整张表的全部内容。为了演示确实是以事务的形式进行操作的，在 service_impl_tx.test_JDBC 中，故意添加具有相同主键的两行，这会令插入操作因不满足唯一性约束条件而失败，示例程序会抛出异常。若要在 SQL 语句执行出现异常时回滚事务，则 @Transactional 注解需要添加 rollbackFor 属性：

```java
@Transactional(rollbackFor = { Exception.class })
```

或在 catch 语句块内或发生异常的语句之前添加（此种方法在实际工程中应用更多）

```java
TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
```

如果忘记定义 org.springframework.jdbc.datasource.DataSourceTransactionManager 实例（示例程序将其添加到了 Spring 配置文件 application-context.xml 中），则无法在事务执行出现问题时将事务撤销。
