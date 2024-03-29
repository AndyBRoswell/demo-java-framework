# 2.2 基于注解的控制器

## 概述

### 处理请求参数的常用方法

被 @Controller 标记的类，有 4 种常用的方法获得客户端请求中的参数。它们均适用于 HTTP GET 和 POST 方法。

其一，通过实体 bean 接收请求参数。

存储请求中携带的数据是通过创建实体类的实例来实现的。实体类的每一个成员变量都需具有对应的 getter 和 setter。

以表单（form）为例。对应的表单中的所有 input 元素的 name 属性的值都必须与该实体类的成员变量的标识符（名称）一一对应；且该表单的 action 属性指向的 URL 必须能够被 @RequestMapping 等注释导引至相应的 @Controller 标注的类的成员方法（处理方法，handler method）；这样的成员方法还需要有一个以该实体类为类型的形参。表单中的类型为 submit 的 input 动作后，通过此方法参数便可访问请求中的对应的数据。

其二，通过处理方法的形参接收请求参数。

仍以表单为例。令表单的每一项需要作为请求参数的 input 的 name 属性，都有对应的处理方法的形参中的一个同名参数与其一一对应。可见，本法不需将表单内容使用一个专门的实体类表示，于是方法一需要的该实体类的形参变为原须作为该实体类的成员变量的多个形参。

其三，通过 @RequestParam 注解接收请求参数。

此方法与方法二的区别是：处理方法中无对应的参数时，返回 400（Bad Request）错误。方法二在面临此情形时不报告此错误。

其四，通过 @ModelAttribute 接收请求参数。

此注解用于标记方法一中提到的实体类。但它比方法一更方便，这主要涉及到数据绑定等知识。数据绑定将在后续章节进一步讲解。此外，通过该注解还可以实现控制权限等功能：被 @ModelAttribute 标记的非处理方法总是在每次调用所在的 @Controller 标记的类的处理方法之前先行被调用。当然，还有许多其它方法实现权限控制。

### 重定向与转发

重定向与转发的主要区别在于：重定向由客户端发起，而转发由服务器发起。
- Web 服务器通过内部的方法将客户端发出的请求转发给同一个 Web 容器下的其它 URL。转发完成后，原有的请求中的信息并不失效。在客户端的浏览器中，转发前后的地址栏的显示内容不变。换言之，客户端并不能察觉服务器进行了转发。
- 另一方面，需要重定向时，服务器总是要向客户端发出 302（Found）状态码。客户端收到 302 响应以后，再以新的 URL 发送一个新的 HTTP 请求。由于重新发出了另外的请求，原有的请求自然就失效了。如果客户端是浏览器，那么重定向后，地址栏中可以看到地址变更为重定向后的地址。

在 Spring 框架中，若处理方法返回 String 类型，则默认为转发实现：将收到的客户端请求转发到了其它视图。

## 例

本例通过实体 bean 接收请求参数，来模拟注册和登录功能。

为了锻炼大家阅读代码的能力，将不会为本例的代码作较多讲解。这里只提一些注意事项：

1. 若 @RequestMapping 等注解仅标记了 @Controller 标记的类，而没有标记其中的成员方法，则试图访问该注解的参数包含的 URL 时，将会报错。
2. 记得不要漏掉 @Controller、@Service、@Autowired 等注解。
