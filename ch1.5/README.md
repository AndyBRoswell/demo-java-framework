# 1.5 Spring 的数据库编程与声明式事务管理

## 概述

Spring 为开发者提供了 JDBC 模板（org.springframework.jdbc.core.JdbcTemplate），用于代码的简化。但是，在实际应用中，JdbcTemplate 并不常用。这里只简要进行介绍。

数据源 org.springframework.jdbc.datasource.DriverManagerDataSource 类的 driverClassName、url、username、password 等成员指定访问数据库所需的驱动、URL、用户名和密码等访问数据库必须的要素。org.springframework.jdbc.core.JdbcTemplate 类的 dataSource 成员指定该 JdbcTemplate 实例关联的数据源：填入 DriverManagerDataSource 实例即可。事务管理器 org.springframework.jdbc.datasource.DataSourceTransactionManager 的 dataSource 属性亦指定其关联的数据源。

Bean 的 property 子节点中，如需以引用类型方式指定值，则使用 ref 属性，而非 value 属性。



## 例

