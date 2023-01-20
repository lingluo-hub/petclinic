# Spring Petclinic

Spring 官方项目 Petclinic 的复刻，使用 MySQL 数据库，相比略有不同。将 thymeleaf 网站页面改为中文。
仅用于对往后 Spring 使用 Gradle 构建、MySQL 数据库的后端项目的参考。

原官方项目: [spring-projects/spring-petclinic](https://github.com/spring-projects/spring-petclinic)

## 数据库初始化

```shell
docker run -e MYSQL_USER=petclinic -e MYSQL_PASSWORD=petclinic -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=petclinic -p 3306:3306 mysql:5.7.8
```
