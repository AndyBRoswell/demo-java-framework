# 2.5 拦截器

## 概述

Spring MVC 的拦截器（interceptor）与 Java Servlet 的过滤器（filter）类似，主要用于在特定的时刻拦截用户的请求并进行处理。多用于登录状态或权限验证、记录日志等常见功能。

## 例

Spring MVC 中，继承 org.springframework.web.servlet.HandlerInterceptor 或 org.springframework.web.servlet.WebRequestInterceptor 均可实现自己的拦截器。本例通过继承 HandlerInterceptor 实现。

preHandle()、postHandle() 和 afterCompletion() 方法调用的时机分别为：请求处理方法调用前；请求处理方法调用后、解析视图前；解析视图后。preHandle() 方法返回 true 则不中断后续操作；返回 false 则中断后续操作。postHandler() 方法可用于对模型和视图加以修改。afterCompletion() 方法可用于进行资源释放、记录日志等工作。

本例通过在 servlet 配置文件 src/main/webapp/dispatcher/main-servlet 中定义拦截器实例并进行配置，来令拦截器发挥作用。一共定义了 1 个全局拦截器和 2 个局部拦截器。通过对拦截器进行配置，可实现仅针对特定的 URL 启用拦截器。注意：在 servlet XML 配置文件中，mvc:mapping 和 mvc:exclude-mapping 两项配置必须放置于拦截器对应的 bean 前。
