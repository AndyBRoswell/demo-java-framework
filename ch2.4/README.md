# 2.4 JSON

## 概述

JSON 是一种轻量级的数据交换格式，用于实体之间的数据传输。JSON 简单的句法利于高性能又不失灵活性，且人类易读，现已成为首选的数据交换格式之一。

Spring 依赖高性能 JSON 库 Jackson 实现 JSON 与 Java 类实例的互相转换。被 @RequestBody 标记的参数将按照 JSON 格式进行解析，并将其转换为 Java 类的实例；被 @ResponseBody 标记的方法，其返回值将被转换为 JSON 格式并作为响应内容传回给客户端。

## 例

本例是一个模拟的产品信息录入系统。

在首页填写音响的产品信息，然后点击 “Add” 按钮添加；点击 “List all speakers” 按钮，查看已添加的全部产品信息。前端使用 AJAX 技术异步发送 HTTP 请求。

为了锻炼大家阅读代码的能力，将不对本例的代码进行专门的讲解。
