# 1.1 使用 XML 文件获得所需的类实例

## 注意事项

如 Spring 版本低于 6（不含），则 Tomcat 的最高版本为 9。并且，不要使用 Jakarta EE 9（jakarta.*）及之后的版本；最高版本为 Java EE 8（javax.*）。

## 概述

本例包含一个接口 test_DAO 及它的一个实现 test_DAO_impl。

application_context.xml 是 Spring 的配置文件。其根节点为 beans，