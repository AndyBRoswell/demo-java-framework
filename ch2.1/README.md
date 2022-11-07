# 2.1 简易的 Spring MVC 服务端程序

## 注意

JSP 已过时，你不应深入学习。如需维护使用 JSP 的项目，则在维护期间按需学习即可。

本章主要使用 JSP 来演示 Spring MVC 的基础功能，是由于考试可能涉及少量 JSP 知识。

## 概述

本节学习如何使用 Spring MVC 搭建一个十分简单的网站。应用程序的架构从顶层到底层进行讲解。

index.jsp 是 Web 应用的首页。访问站点时，默认打开的是首页。

web.xml 定义了如何将 URL 映射到对应的 servlet。通常在 web.xml 中声明 org.springframework.web.servlet.DispatcherServlet。每个 DispatcherServlet 都有一个对应的 xml 文件：默认情况下，它的 basename 是 DispatcherServlet 的名称加上 “-servlet” 后缀。DispatcherServlet 的 XML 配置文件中，可以声明 bean，其类名为 org.springframework.web.servlet.view.InternalResourceViewResolver 实例。可以为这个 bean 添加 prefix 和 suffix 两个 property 子节点，它们代表查找对应的网页文件时总是添加何种前缀或后缀。

使用 @Contoller 注解标记特定的类为 Controller。@RequestMapping 既可以标记整个被 @Controller 标记的类，又可以标记被 @Controller 标记的类的成员方法。@RequestMapping 的参数可以控制匹配的 URL、HTTP 方法、请求参数、头和媒体类型。以下几个注解仅匹配特定的方法：
- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping
- @PatchMapping

可以使用 ? 和 * 通配符匹配符合特定模式的 URL，也可以使用 {} 将匹配到的 URL 中的一个片段使用变量来表示。{} 中还可以使用正则表达式（regex）。

被 @RequestMapping 等注解标记的被 @Controller 标记的类的成员方法，其参数和返回值有多种形式。

## 例

在 IntelliJ IDEA 中，新建 Spring MVC 工程时，可在 Template 处选择 Web application，即可自动为开发的软件生成必要的目录结构。Application Server 选择 Tomcat 的安装目录。

