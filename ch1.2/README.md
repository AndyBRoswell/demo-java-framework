# 1.2 使用注解获得类实例

## 概述

有时，编写 / 修改用于控制反转 / 依赖注入的 XML 比较繁琐，不够方便。频繁在 java 文件和 xml 文件之间切换，也容易引发思维的不连贯，影响开发。此时，可以使用注解来代替 XML。使用注解也是更为推荐的方法。

为了令软件具备可扩展性与易维护性，具有一定规模的软件往往被分为若干个层次（layer）或模块（module）。

Spring 为软件架构中的这些常见的层提供了有关依赖注入的、用于声明 bean 的注解：
- @Controller 标注控制（器）层。
- @Service 标注服务层。
- @Repository 标注数据访问层（持久层）。

不难看出，控制（器）层、服务层和数据访问层（持久层），是依次从上层（应用层）到底层（核心层）的几个层次。这几个层常见于众多知名的大型软件。

注意：这些标注不是随意使用、随意互换的。错误使用这些标注，不但使代码结构不清晰、难于阅读，而且还会影响 Spring 带来的其它功能。例如：只有被 @Repository 标记的类，Spring 才能将这些类的实例抛出的、来自不同数据库或持久层框架（Hibernate、MyBatis、Spring Data 等）的异常转化（封装）为 Spring 自身的异常，进而令开发人员得以便捷地统一处理它们。

Spring 还提供了用于注入 bean 的注解：
- @Autowired 可以标注成员变量与成员方法（含构造方法）。对于一个类，不再需要在 XML 中为该类对应的 bean 节点添加对应于被标记的成员变量的 property 子节点；也不再需要为此成员变量编写 getter 和 setter。默认情况下，被 @Autowired 标记的成员变量，被赋予一个与其类型匹配的实例。
- @Qualifier 与 @Autowired 连用。其参数是需要赋予 @Autowired 标记的成员变量的实例的名称。
  - 一个情形：@Autowired 标记的成员变量的类型是一个接口，它具有多个实现。使用 @Qualifier 指定其中一个实现的类名，否则报错（不知道需要哪一个实现类）。

@Resource 并不是 Spring 的注解，而是 Java EE / Jakarta EE 的注解。被 @Resource 标记的成员变量，默认被赋予一个 id（名称）与 @Resource 的参数相符的 bean。若找不到，则尝试赋予一个类型与 @Resource 的参数相符的 bean。

使用 @Autowired 与 @Resource 时，Spring XML 配置中需要
```xml
<context:component-scan base-package=""/>
```
一行。base-package 指定扫描是否存在使用这些注解的类的范围。注意为 beans 根元素声明命名空间属性
```xml
xmlns:context="http://www.springframework.org/schema/context"
```

## 例

在本例中，test_controller 类、test_service 接口及其实现、test_DAO 接口及其实现，分别对应控制、服务和数据访问层。每个 test_controller 实例都有一个 test_service 实例；每个 test_service 实例都有一个 test_DAO 实例。

本例使用了如下用于声明 bean 的注解：
- test_DAO 的一个实现类 test_DAO_impl 被注解 @Repository("test_DAO_impl") 标注。
- test_service 的一个实现类 test_service_impl 被 @Service("test_service_impl") 标注。
- test_controller 被 @Controller 标注。

本例使用了如下用于注入 bean 的注解：
- test_service_impl.test_DAO 被 @Resource(name = "test_DAO_impl") 标记。将为 test_DAO 成员赋予一个 test_DAO_impl 类型的实例。这个 @Resource 注解相当于 @Autowired。
- test_controller 的 test_service 成员被 @Autowired 标记。test_service 只有一个实现类 test_service_impl。它的实例将被赋给该 test_service 成员。
