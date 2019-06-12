# Spring Cloud 配置中心

> 快速启动

本地

```
启动 ConfigApplication.java
访问 http://localhost:8888/
输入用户名为 user 
密码为环境变量CONFIG_SERVICE_PASSWORD的值
```

jar启动

```
mvn clean

mvn package

java -jar config.jar
```

docker 启动

```shell
mvn clean

mvn package

docker build -t config:latest .

docker run -d -p 8888:8888 config:latest 

. 表示当前目录
```

> 监控服务状态

http://localhost:8888/actuator 

![](http://ww1.sinaimg.cn/large/006tNc79ly1g35bc4m36cj30io0duq3r.jpg)