# 1.4 Spring 实例化管理的类的三种方法&emsp;bean 的作用域

## 概述

对于由 Spring IoC 容器接管的类，仍然可以使用多种方法将该类实例化。Spring 框架支持构造方法、静态工厂和实例工厂三种方式。

## 例

本例有一个类 bean_class，具有 public 访问控制的构造函数。与此同时，还具有 bean_instance_factory 和 bean_static_factory 两个类，分别代表 bean_class 的实例工厂和静态工厂。

在 Spring 配置文件 application_config.xml 中，声明了 4 个 bean：
- constructor_instance 代表 bean_class 实例；
- static_factory_instance 代表 bean_class 的静态工厂；
- instance_factory_instance 代表 bean_class 的实例工厂。使用实例工厂创建所需的类的实例时，先创建一个该工厂的实例 my_factory，再调用该实例的工厂方法（create_instance）。

## 概述



## 例

