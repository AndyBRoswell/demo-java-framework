# 1.4 Spring 实例化管理的类的三种方法

## 概述

对于由 Spring IoC 容器接管的类，仍然可以使用多种方法将该类实例化。Spring 框架支持构造方法、静态工厂和实例工厂三种方式。

## 例

本例有一个类 bean_class，具有 public 访问控制的构造函数。与此同时，还具有 bean_instance_factory 和 bean_static_factory 两个类，分别代表 bean_class 的实例工厂和静态工厂。

在 Spring 配置文件 application_config.xml 中，