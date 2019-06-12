# 注册中心

> 快速启动

本地

```
启动 RegistryApplication.java
访问 http://localhost:8888/
输入用户名为 user 
密码为环境变量CONFIG_SERVICE_PASSWORD的值
```

jar启动

```
mvn clean

mvn package

java -jar registry.jar
```

docker 启动

```shell
mvn clean

mvn package

docker build -t registry:latest .

docker run -d -p 8888:8888 registry:latest 

. 表示当前目录
```