# java-framework-sample

A laconic tutorial of frequently-used frameworks.

## 参考资料

1. 陈恒、李正光&emsp;SSM+Spring Boot+Vue.js 3 全栈开发从入门到实践&emsp;清华大学出版社&emsp;2022

# 环境

- Windows
- IntelliJ IDEA
- JDK
- Tomcat

# 第零章 包管理工具

## 0.1 Maven 简介

Maven 是 Apache 软件基金会（Apache Software Foundation）的一个软件项目管理工具。

Maven 使用一个叫做项目对象模型（project object model，POM）的概念，令开发人员仅使用少量 XML 代码就能完成依赖（所需的来自其它软件的代码）管理、设定编译选项等工作。众多知名的 Java 软件项目使用 Maven 管理依赖，从而无需通过繁琐的手工操作（如：复制所需的 jar 文件到项目目录下，等等）以使软件能够正常使用第三方库。

Maven 可以单独安装使用，也可以直接使用 IntelliJ IDEA 等 IDE 集成的版本。

使用 Maven 的项目中，项目目录下的 pom.xml 描述了项目的名称、依赖、编译选项等信息。

## 0.2 常见的 Maven 元素

### project

pom.xml 的唯一一个根元素。

### project.groupId & project.artifactId

决定项目的包名（package name）。其它项目引用自己的项目时，需要正确书写包名。Java 的包名只能包含字母、数字、下划线和美元符号（$），且不能以数字开头、不能与 Java 关键字（保留字）重名。

本仓库的示例项目统一使用的 groupId 是：top.abr.fwsample；1.1 节的示例代码的 artifactId 是：ch1_1。于是，引用本项目的 java 源文件需要通过类似如下的语句来导入本项目：

```java
import top.abr.fwsample.*;
import top.abr.fwsample.ch1_1;
```

groupId 的命名往往与作者的官方网站有关。如：

```java
com.sun.sunsoft.DOE;        // sun.com
com.sun.java.jag.scrabble;
com.apple.quicktime.v2;     // apple.com
edu.cmu.cs.bovik.cheese;    // cs.cmu.edu
org.apache.maven;           // apache.org
org.apache.commons;
```

### project.version

项目的版本号。如：1.0-SNAPSHOT、1.0.0。

### project.name

项目的名称。

### packaging

项目的打包格式：jar 或 war。开发 Web 项目时，格式一般选用 war。

### 属性（如：project.properties）

项目或其它元素 / 节点的属性。

#### 环境变量

在 pom.xml 中，可以读取环境变量。如：

```xml
${env.PATH}
```

注意：在 Windows 下，环境变量不区分大小写。但 pom.xml 查找属性时区分大小写。

#### Java 系统属性

所有通过
```java
java.lang.System.getProperties()
```
获得的属性，均可在 pom.xml 中使用。如：

```xml
${java.home}
```

#### 自定义变量

可以在 properties 元素中添加自定义变量。

#### 访问本项目的 pom.xml 中的元素 / 节点

如：

```xml
${project.build.sourceEncoding}
```

#### project.build.sourceEncoding

源码的字符编码（字符集）。原则上都应当使用 UTF-8。

#### maven.compiler.source

源文件正常编译所需的最低 Java 版本（JDK 版本）。如：1.8 或 8 表示源码需要 JDK 8 及更高版本进行编译。

#### maven.compiler.target

编译的目标平台的最低 Java 版本（JVM 版本）。如：17 表示编译得到的 Java 字节码需要在 Java 17 下运行。

使用更高的 Java 版本有利于提升性能。

### project.dependencies

项目所需的依赖。每一个 dependency 元素描述一项依赖的信息。如：包名、版本号，等等。例：

```xml
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-beans</artifactId>
	<version>5.3.23</version>
</dependency>
```
表示需要 5.3.23 版本的 org.springframework。

在 IntelliJ IDEA 中，每次改动 pom.xml 后，pom.xml 的编辑区域都会浮现一个右下角带有🔄标志的斜体 “m”。点击此按钮，将更改进行应用。应用更改的过程会进行诸如下载缺少的依赖等操作。

在 mvnrepository.com 中，搜索所需的包，可以直接得到在 pom.xml 中为引用该包需要补充的 dependency 元素。

# 第一章 Spring

## 注意事项

如 Spring 版本低于 6，则 Tomcat 的最高版本为 9。并且，不要使用 Jakarta EE 9（jakarta.\*）及之后的版本；最高版本为 Java EE 8（javax.\*）。

自 Spring 6 / Spring Boot 3 开始，要求 Java 17 及 Jakarta EE 9 版本。

## 目录

- 1.1 使用 XML 文件获得所需的类实例
- 1.2 使用注解获得类实例
- 1.3 使用面向方面编程（AOP）以更少的代码量扩展所需功能
- 1.4 Spring 实例化管理的类的三种方法&emsp;bean 的作用域&emsp;bean 的生命周期
- 1.5 Spring 的数据库编程和声明式事务管理

## 概述

初识 Spring，了解基础知识。

# 第二章 Spring MVC

## 目录

- 2.1 简易的 Spring MVC 服务端程序
- 2.2 基于注解的控制器
- 2.3 数据绑定
- 2.4 JSON
- 2.5 拦截器

## 概述

Spring MVC（正式名称：Spring Web MVC）是一个主要用于开发 Web 应用的知名框架。其实现了 MVC（Model-View-Controller）这一经典的软件架构（也称架构模式，architecture pattern），有利于降低软件的各个模块间的耦合程度，进而提高软件的可扩展性与可维护性。许多软件架构，如 MVP（Android）、MVVM（WPF、MAUI）、MVT（Django）等，其设计思想在本质上都与 MVC 相似。

使用 Spring MVC 开发的服务器端软件，由上层到底层的主要结构大致是：
- DispatcherServlet
- HandlerMapping / Controller / ViewResolver / View
- Service / Model

在 Spring MVC 中，浏览器或其它可以访问网络的软件作为客户端。与客户端直接进行通信的是 DispatcherServlet：它既负责接收客户端发起的请求，也负责将响应发回给客户端。DispatcherServlet 根据 HandlerMapping 将请求提交给适当的 Controller。Controller 可能直接调用 Model 进行处理，也可以调用 Service 而由 Service 调用 Model 进行处理。业务逻辑通常集中在 Controller 与 Service 部分；而 Model 则直接与数据打交道，如：访问数据库、读写磁盘，乃至与其它网络进行通信，等等。由 Service 与 Model 将请求处理完毕以后产生的响应将返回给 Controller。Controller 将响应传回给 DispatcherServlet。DispatcherServlet 再按需调用 ViewResolver 和相应的 View，最终将响应回传给客户端。

本项目使用 Spring Framework 5.3 以及 Tomcat 9。运行本章的示例前，请先将 Tomcat 9 安装完毕，然后打开安装目录下的 bin/Tomcat9w.exe 将已启动的 Tomcat 9 服务停止运行，并将其设为手动启动。否则，在 IntelliJ IDEA 中编译示例代码并启动时，将会提示端口 8080 被占用。当然，具有一定计算机网络知识和网络编程经验的读者，亦可手动在 IntelliJ IDEA 或 Tomcat9w.exe 中，更改两者之一的端口。

# 第三章 MyBatis

## 目录

## 概述

关系模型（relational model）是一种成熟的数据模型，它与实际工作中的大量类型的数据都切合得很好，是众多场景中解决各种问题的有力工具。但关系模型主要源于数学理论。相比之下，面向对象编程（OOP）则主要源于软件工程。因此，在编程语言中操作关系模型中的表，是不太方便的。为了能够使用面向对象编程专有的方法便利地操纵数据，当需要对实体进行具备一定复杂度的处理时，通常将实体以类的形式描述，然后通过对象关系映射（Object Relational Mapping，ORM）框架将其转换为关系数据库中的表。

Java 平台有许多 ORM 框架，包括 Hibernate、MyBatis、Spring Data JPA 等。本章简要学习 MyBatis。MyBatis 原名 iBatis，后改称 MyBatis。作为 Java 持久层框架，MyBatis 力求消除 JDBC 代码中需要重复性地手工编码的部分，包括参数的设置和结果集的检索等步骤。MyBatis 主要使用 XML 或注解指定如何将类（一般是接口和 POJO 类）对应到数据库中的记录。
