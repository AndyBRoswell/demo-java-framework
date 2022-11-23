# 2.3 数据绑定

## 概述

数据绑定（data binding）是一种令数据与其使用者同步的技术。数据绑定一般用于数据源（数据生产者）和数据使用者（数据消费者）以不同语言进行描述的场合。如：在 WPF / MAUI 中，将 XAML 描述的 GUI 部件与对应的 C# 变量进行绑定。将数据源与数据使用者绑定后，一旦数据源提供的数据发送变化，数据使用者展示的数据将自动更新。有时，为数据消费者绑定其不直接接受的类型的数据，还能令开发者省区类型转换的代码。

在 Web 开发中，如使用数据绑定，可以实现在提交输入被拒绝时，在退回的页面的表单中保留之前输入的数据，无需用户重新输入它们。

## 例

配合 Spring MVC 框架实现数据绑定的方法有多种。这里简要介绍使用 JSP 的做法。

本例是一个模拟的排片系统。

src/main/webapp/WEB-INF/web.xml 中声明了名为 main 的 servlet，其 init-param 指定了需要寻找符合 /dispatcher/*.xml 的上下文配置 XML。客户端发出的所有请求，都会由这个名为 main 的 servlet 分发。src/main/webapp/dispatcher/main.xml 定义了该 servlet 的类型为 org.springframework.web.servlet.view.InternalResourceViewResolver，且匹配视图路径名时总是添加前缀 “/page” 和后缀 “.jsp”。本节的示例项目的所有网页都放置于 src/main/webapp/page 中。

在首页 index.jsp 可以选择添加新的排片或查看已有排片。这只是一个十分简单的演示项目，并没有数据库。因此，服务器关闭后，已有的排片数据即丢失。添加排片和查看排片两个页面对应的视图文件分别为 add-session.jsp 和 sessions.jsp。

