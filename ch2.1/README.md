# 2.1 简易的 Spring MVC 服务端程序

## 注意

JSP 已过时，你不应深入学习。如需维护使用 JSP 的项目，则在维护期间按需学习即可。

本章主要使用 JSP 来演示 Spring MVC 的基础功能，是由于考试可能涉及少量 JSP 知识。

Spring 并不强制要求开发者只使用 JSP 视图技术。

## 概述

本节学习如何使用 Spring MVC 搭建一个十分简单的网站。应用程序的架构从顶层到底层进行讲解。

index.jsp 是 Web 应用的首页。访问站点时，默认打开的是首页。

web.xml 通过 servlet-mapping 定义了如何将 URL 映射到对应的 servlet。通常在 web.xml 中声明 org.springframework.web.servlet.DispatcherServlet。

每个 DispatcherServlet 都有一个对应的 xml 文件：默认情况下，它的 basename 是 DispatcherServlet 的名称加上 “-servlet” 后缀。在该 XML 配置文件中，可以声明 bean，其类名为 org.springframework.web.servlet.view.InternalResourceViewResolver 实例。可以为这个 bean 添加 prefix 和 suffix 两个 property 子节点，它们代表 InternalResourceViewResolver 查找对应的视图文件时总是添加何种前缀或后缀。默认条件下，Spring 框架从 WEB-INF 目录（web.xml 所在目录）下查找 DispatcherServlet 的 XML 配置文件；若需要在其它目录下查找，可以通过为 web.xml 中的相应的 servlet 节点添加 init-param 子节点（param-name 为 contextConfigLocation），来指定查找的目录。

使用 @Contoller 注解标记特定的类为 Controller。@RequestMapping 既可以标记整个被 @Controller 标记的类，又可以标记被 @Controller 标记的类的成员方法。@RequestMapping 的参数可以控制匹配的 URL、HTTP 方法、请求参数、头和媒体类型。以下几个注解仅匹配特定的方法：
- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping
- @PatchMapping

可以使用 ? 和 * 通配符匹配符合特定模式的 URL，也可以使用 {} 将匹配到的 URL 中的一个片段使用变量来表示。{} 中还可以使用正则表达式（regex）。

被 @RequestMapping 等注解标记的被 @Controller 标记的类的成员方法，其参数和返回值有多种形式，来实现不同的功能。

## 例

在 IntelliJ IDEA 中，新建 Spring MVC 工程时，可在 Template 处选择 Web application，即可自动为开发的软件生成必要的目录结构。Application Server 选择 Tomcat 的安装目录。

如果是直接拉取本仓库的源码并尝试直接运行，而非依据每个章节的 README 一步一步动手搭建，则点击 IntelliJ IDEA 界面右上角的运行（绿色的▶️）按钮的左侧的 “Run/Debug Configurations” 下拉框，点击 “Edit Configurations...” 项，在弹出的 Run/Debug Configurations 窗口中，新建一个 Tomcat Server 配置（选 Local 而非 Remote），将 Application Server 填入 Tomcat 的安装目录。

通过 IntelliJ IDEA 运行本例的源码之前，通过 Run/Debug Configurations 窗口，在 Tomcat 配置的 Server 选项卡中，将 URL 改为 http://localhost:8080 。则每次调试与运行开始时，都自动访问 localhost:8080 ；在 Deployment 选项卡中，将 Application Context 留空，以便访问 localhost:8080 时能够正确打开首页并顺利导向其它链接。

在本例中，首页包含两个链接，分别导向注册和登录界面。在 web.xml 中声明了一个 DispatcherServlet 实例，其名称为 request-dispatcher，所有 URL 都会由该 DispatcherServlet 处理。对应的 request-dispatcher-servlet.xml 中，声明了一个 InternalResourceViewResolver 实例作为 bean。该实例的两个 property 子节点分别指定了：总是匹配路径名包含 /WEB-INF/jsp/ 前缀且后缀为 .jsp 的网页。

本例定义了一个 index_controller 类。通过 @RequestMapping 注解，将 URL 为 /login 和 /reg 的所有请求都导向 login() 和 register() 成员方法。这两个方法分别返回字符串 login 和 register，它们代表能够被 ViewResolver 解析的视图名称。于是，在点击首页的 “注册” 和 “登录” 两个链接时，发送的 HTTP 请求中的 URL 分别为 /login 和 /reg；/WEB-INF/jsp/login.jsp 和 /WEB-INF/jsp/register.jsp 网页分别被返回给客户端。
