# 3.1 简单的 MyBatis 入门程序

## 概述

MyBatis 的核心配置文件常常命名为 mybatis-config.xml。该配置文件主要制定了数据库的驱动、URL、用户名和密码等连接所用的基本参数，并指定用于将 Java 的类映射到关系数据库的表的映射文件（xml 格式）。

## 例

本例选用了最新的 MyBatis 3.5.11 演示如何连接到 MySQL Community 8.0.31 进行简单的 CRUD 操作。

本例仍然使用 1.5 节创建的 spring_test 数据库和其中的一张表 user。同名的 Java 类 user 借由映射文件 src/resources/mybatis_mapper/user-mapper.xml 被 MyBatis 转换为表 spring_test.user 中的记录（即行）。

测试类 test/java/test 演示了如何读入 MyBatis 核心配置并调用核心配置指定的映射文件中编写的 SQL 语句来操纵数据库。
