# Spring Petclinic

Spring 官方项目 Petclinic 的复刻，使用 MySQL 数据库，相比略有不同。将 thymeleaf 网站页面改为中文。
仅用于对往后 Spring 使用 Gradle 构建、MySQL 数据库的后端项目的参考。

原官方项目: [spring-projects/spring-petclinic](https://github.com/spring-projects/spring-petclinic)

## 数据库初始化

```shell
docker run -e MYSQL_USER=petclinic -e MYSQL_PASSWORD=petclinic -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=petclinic -p 3306:3306 mysql:5.7.8
```

## 环境变量说明

- `MYSQL_URL`: MySQL 连接地址，默认为 `jdbc:mysql://localhost:3306/petclinic`
- `MYSQL_USER`: MySQL 用户名，默认为 `petclinic`
- `MYSQL_PASS`: MySQL 用户密码，默认为 `petclinic`

## 构建 docker 镜像

```shell
git clone https://github.com/lingluo-hub/petclinic.git
./gradlew build -x test
docker build -t adaclosure/petclinic:3.0.0 .
```

## 运行容器编排

启动：
```shell
docker-compose up -d
```

停止销毁：
```shell
docker-compose down
```

### 访问服务

- Petclinic 主页：[http://localhost:8080](http://localhost:8080)
- MySQL 后台管理 - PhpAdmin：[http://localhost:8081](http://localhost:8081)，用户名和密码均为 `petclinic`