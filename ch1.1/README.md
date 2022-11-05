# 1.1 使用 XML 文件获得所需的类实例

## 注意事项

如 Spring 版本低于 6（不含），则 Tomcat 的最高版本为 9。并且，不要使用 Jakarta EE 9（jakarta.\*）及之后的版本；最高版本为 Java EE 8（javax.\*）。

## 概述

本例包含一个接口 test_DAO 及它的一个实现 test_DAO_impl。

application_context.xml 是 Spring 的配置文件。其根节点为 beans。它包含若干个 bean 子节点。bean 节点的 class 属性指定的类名可被 Spring IoC（控制反转）容器管理。

在 org.springframework.context.support.ClassPathXmlApplicationContext 类的构造函数中，指定包含 bean 的 XML 文档。通过类的 getBean 方法，以 id 作为参数，将返回指定的类的一个实例。如有多个位置需要获得该类的实例，则每一处都可以使用同一份 XML 文档。

在某些场景中，这样的做法利于降低调用者与被调用者之间的耦合程度——在这里，调用者需要获取被调用者的实例：

- 该 XML 文件中，每个 bean 的 id 属性一般是不变的。如果 bean 对应的类（它总是某个类的子类）的类名尚未最终敲定，那么在类名更改以后，获取一个该类的实例的代码不需变动。
- 相比之下，若直接使用 new 运算符。则类名变化后，获取一个该类的实例的代码需要变动（new 后的类名改为修改后的类名）。

本例中，application_context.xml 放在了 src/resources 目录的 config 目录下。ClassPathXmlApplicationContext 的构造方法需要传入 config/application_context.xml 字符串。
