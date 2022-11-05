# java-framework-sample
 A laconic tutorial of frequently-used framework.

# 环境

- IntelliJ IDEA
- JDK

# 第零章 包管理工具

# 0.1 Maven 简介

Maven 是 Apache 软件基金会（Apache Software Foundation）的一个软件项目管理工具。

Maven 使用一个叫做项目对象模型（project object model，POM）的概念，令开发人员仅使用少量代码就能完成依赖（所需的来自其它软件的代码）管理、设定编译选项等工作。众多知名的 Java 软件项目使用 Maven 管理依赖，从而无需通过繁琐的手工操作（如：复制所需的 jar 文件到项目目录下，等等）以使软件能够正常使用第三方库。

Maven 可以单独安装使用，也可以直接使用 IntelliJ IDEA 等工具集成的版本。

使用 Maven 的项目中，项目目录下的 pom.xml 描述了项目的名称、依赖、编译选项等信息。

# 0.2 常见的 Maven 元素

## project

pom.xml 的唯一一个根元素。

## project.groupId & project.artifactId

决定项目的包名（package name）。其它项目引用自己的项目时，需要正确书写包名。Java 的包名只能包含字母、数字、下划线和美元符号，且不能以数字开头、不能与 Java 关键字（保留字）重名。

本示例项目的 groupId 是：top.abr.fwsample；1.1 节的示例代码的 artifactId 是：ch1_1。于是，引用本项目的 java 源文件需要通过类似如下的语句来导入本项目：

```java
import top.abr.fwsample.*;
import top.abr.fwsample.ch1_1;
```
groupId 的命名往往与作者的官方网站有关。如：

```java
com.sun.sunsoft.DOE;        // sun.com
com.sun.java.jag.scrabble;
com.apple.quicktime.v2;     // apple.com
edu.cmu.cs.bovik.cheese;    // cs.cmu.edu
org.apache.maven;           // apache.org
org.apache.commons;
```

## project.version

项目的版本号。如：1.0-SNAPSHOT、1.0.0。

## project.name

项目的名称。

## packaging

项目的打包格式：jar 或 war。

## 属性（如：project.properties）

项目或其它元素 / 节点的属性。

### 环境变量

在 pom.xml 中，可以读取环境变量。如：

```xml
${env.PATH}
```

注意：在 Windows 下，环境变量不区分大小写。但 pom.xml 查找属性时区分大小写。

### Java 系统属性

所有通过

```java
java.lang.System.getProperties()
```

获得的属性，均可在 pom.xml 中使用。如：

```xml
${java.home}
```

### 自定义变量

可以在 properties 元素中添加自定义变量。

### 访问本项目的 pom.xml 中的元素 / 节点

如：

```xml
${project.build.sourceEncoding}
```

### project.build.sourceEncoding

源码的字符编码（字符集）。强烈建议使用 UTF-8。

### maven.compiler.source

源文件正常编译所需的最低 Java 版本（JDK 版本）。如：1.8 或 8 表示源码需要 JDK 8 及更高版本进行编译。

### maven.compiler.target

编译的目标平台的最低 Java 版本（JRE / JVM 版本）。如：17 表示编译得到的 Java 字节码需要在 Java 17 下运行。

使用更高的 Java 版本有利于提升性能。

## project.dependencies

项目所需的依赖。每一个 dependency 元素描述一项依赖的信息。如：包名、版本号，等等。例：

```xml
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-beans</artifactId>
			<version>5.3.23</version>
		</dependency>
```
表示需要 5.3.23 版本的 org.springframework。

在 IntelliJ IDEA 中，每次改动 pom.xml 后，pom.xml 的编辑区域都会浮现一个右下角带有🔄标志的斜体 “m”。点击此按钮，将更改进行应用。应用更改的过程会进行诸如下载缺少的依赖等操作。

# 第一章 Spring

