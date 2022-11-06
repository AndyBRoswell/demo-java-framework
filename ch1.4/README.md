# 1.4 Spring 实例化管理的类的三种方法&emsp;bean 的作用域&emsp;bean 的生命周期

## 概述

对于由 Spring IoC 容器接管的类，仍然可以使用多种方法将该类实例化。Spring 框架支持构造方法、静态工厂和实例工厂三种方式。

## 例

本例有一个类 bean_class，具有 public 访问控制的构造函数。与此同时，还具有 bean_instance_factory 和 bean_static_factory 两个类，分别代表 bean_class 的实例工厂和静态工厂。

在 Spring 配置文件 application_config.xml 中，声明了 4 个 bean：
- constructor_instance 代表 bean_class 实例；
- static_factory_instance 代表 bean_class 的静态工厂；
- instance_factory_instance 代表 bean_class 的实例工厂。使用实例工厂创建所需的类的实例时，先创建一个该工厂的实例 my_factory，再调用该实例的工厂方法（create_instance）。

## 概述

Bean 的作用域有 6 种：
- singleton。这是默认的作用域，一个 Spring 容器只有一个该实例。
- prototype。每次获取该 bean 时，都创建一个新实例。
- request。一次 HTTP 请求仅包含一个该实例。
- session。一个 HTTP Session 仅包含一个该实例。
- application。一个 ServletContext 对象仅包含一个该实例。
- websocket。一个 WebSocket 对象仅包含一个该实例。

作用域决定调用 getBean 方法时是否返回新的实例。singleton 和 prototype 是最常用的作用域，其它作用域一般仅出现在使用 Spring 的 Web 开发中。

## 例

多次获取 singleton 作用域的 bean，可以看到：每个引用都指向同一个对象。
多次获取 prototype 作用域的 bean，可以看到：每个引用都指向不同的对象。

## 概述

Spring 框架读取 XML 配置文件（加载容器）时，就会实例化 bean 元素指定的类。关闭容器时，执行指定的类的销毁方法。应当在该销毁方法中，完成销毁对象所需的工作（如：释放资源等）。

## 例

运行 test_init_and_destroy.main(String[]) 方法，查看结果即可。
