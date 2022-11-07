# 2.1 简易的 Spring MVC 服务端程序

## 注意

JSP 已过时，你不应深入学习。如需维护使用 JSP 的项目，则在维护期间按需学习即可。

本章主要使用 JSP 来演示 Spring MVC 的基础功能，是由于考试可能涉及少量 JSP 知识。

## 概述

本节学习如何使用 Spring MVC 搭建一个十分简单的网站。应用程序的架构从顶层到底层进行讲解。

index.jsp 是 Web 应用的首页。访问站点时，默认打开的是首页。

web.xml 定义了如何将 URL 映射到对应的 servlet。

## 例

在 IntelliJ IDEA 中，新建 Spring MVC 工程时，可在 Template 处选择 Web application，即可自动为开发的软件生成必要的目录结构。Application Server 选择 Tomcat 的安装目录。

