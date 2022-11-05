# 1.1 使用 XML 文件获得所需的类实例

## 注意事项

如 Spring 版本低于 6（不含），则 Tomcat 的最高版本为 9。并且，不要使用 Jakarta EE 9（jakarta.*）及之后的版本；最高版本为 Java EE 8（javax.*）。

## 概述

本例包含一个接口 test_DAO 及它的一个实现 test_DAO_impl。

application_context.xml 是 Spring 的配置文件。其根节点为 beans。它包含若干个 bean 子节点。bean 节点的 class 属性指定的类名可被 Spring IoC（控制反转）容器管理。

在 org.springframework.context.support.ClassPathXmlApplicationContext 类的构造函数中，指定包含 bean 的 XML 文档。通过类的 getBeans 方法，以 id 作为参数，将返回指定的类的一个实例。

本例中，application_context.xml 放在了 src/resources 目录的 config 目录下。ClassPathXmlApplicationContext 的构造方法需要传入 config/application_context.xml 字符串。
