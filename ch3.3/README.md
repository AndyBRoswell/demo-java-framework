# 3.3 Spring、Spring MVC 和 MyBatis 三大框架的整合开发

## 例

本例引用了较多的依赖——在编写本例时，所有依赖均选用了最新版。注意 pom.xml 中的一些依赖的写法：部分旧有写法已经废弃（deprecated），并未被选用。

运行本例前，需要先为本例创建专门的用户：

```sql
create user 'java-framework-sample-ch3.3' identified by '0';
grant all privileges on *.* to 'java-framework-sample-ch3.3';
```

本例需要用到的表：

```sql
create table spring_test.id_card (
	id bigint not null auto_increment,
    code varchar(18) collate utf8mb4_0900_ai_ci default null,
    primary key(id)
);
create table spring_test.person (
	id bigint not null auto_increment,
    name varchar(20) collate utf8mb4_0900_ai_ci default null,
    age smallint default null,
    id_card_id bigint default null,
    primary key(id),
    key id_card_id (id_card_id),
    constraint FK_id_card_id foreign key(id_card_id) references spring_test.id_card(id)
);
```