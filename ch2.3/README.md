# 2.3 数据绑定

## 概述

数据绑定（data binding）是一种令数据与其使用者同步的技术。数据绑定一般用于数据源（数据生产者）和数据使用者（数据消费者）以不同语言进行描述的场合。如：在 WPF / MAUI 中，将 XAML 描述的 GUI 部件与对应的 C# 变量进行绑定。将数据源与数据使用者绑定后，一旦数据源提供的数据发送变化，数据使用者展示的数据将自动更新。有时，为数据消费者绑定其不直接接受的类型的数据，还能令开发者省区类型转换的代码。

在 Web 开发中，如使用数据绑定，可以实现在提交输入被拒绝时，在退回的页面的表单中保留之前输入的数据，无需用户重新输入它们。

## 例

配合 Spring MVC 框架实现数据绑定的方法有多种。这里简要介绍使用 JSP 的做法。

本例是一个模拟的排片系统。

src/main/webapp/WEB-INF/web.xml 中，声明了名为 main 的 servlet，其 init-param 指定了需要寻找符合 /dispatcher/*.xml 的上下文配置 XML。客户端发出的所有请求，都会由这个名为 main 的 servlet 分发。src/main/webapp/dispatcher/main.xml 定义了该 servlet 的类型为 org.springframework.web.servlet.view.InternalResourceViewResolver，且匹配视图路径名时总是添加前缀 “/page” 和后缀 “.jsp”。本节的示例项目的所有网页都放置于 src/main/webapp/page 中。

src/main/webapp/WEB-INF/web.xml 中，还强制编码为 UTF-8，以免中文显示乱码。

在首页 index.jsp 可以选择添加新的排片或查看已有排片。这只是一个十分简单的演示项目，并没有数据库。因此，服务器关闭后，已有的排片数据即丢失。

添加排片和查看排片两个页面对应的视图文件分别为 add-session.jsp 和 sessions.jsp。

在 add-session.jsp 中，开头的
```jsp
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
```
语句令该 jsp 可以使用表单标签库（taglib），以实现表单数据与 Java 类实例绑定。

在该页面中，一些标签以 “form:” 前缀开头，它们将参与数据绑定。checkboxes 和 select 的内容由 items 属性决定；path 属性与需要绑定的 Java 类的成员变量名一致。

使用 post 方法提交后，该 HTTP 请求将被分发给由 @PostMapping 标记的 index_navigator.add_film_session 成员方法。该方法的 film_session 型参数 session 被 @ModelAttribute 标记，代表参数 session 被该表单绑定，表单中的数据将传递给 session 参数的各个成员变量。

在 sessions.jsp 中，开头的
```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```
语句令该 jsp 可以使用 JSTL。

c:forEach 标签的 items 属性指定了需要遍历的对象（该对象被绑定）。index_navigator.list_film_sessions 成员方法中，通过 org.springframework.ui.Model.addAttribute 成员函数添加该对象用于遍历。

c:forEach 标签的 var 对象用于取得遍历过程中当前访问到的元素。通过该标识符，可以取得元素（被绑定的 Java 类实例）的成员。如果直接指定成员变量的名称无法取得该变量的值，也可以改为调用该变量的 getter 取得其值。
