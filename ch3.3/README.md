# 3.3 Spring、Spring MVC 和 MyBatis 三大框架的整合开发

## 例

本例引用了较多的依赖——在编写本例时，所有依赖均选用了最新版。注意 pom.xml 中的一些依赖的写法：部分旧有写法已经废弃（deprecated），并未被选用。

运行本例前，需要先为本例创建专门的用户：

```sql
create user 'java-framework-sample-ch3.3' identified by '0';
grant all privileges on *.* to 'java-framework-sample-ch3.3';
```

