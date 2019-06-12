1. bootstrap.yml先于application.properties被加载。

2. 当使用Spring Cloud Config Server时，需要将spring.application.name和spring.cloud.config.server.git.uri写入bootstrap.yml。

3. 一些encryption/decryption（加密/解密）存储在bootstrap.yml里面。

4. bootstrap.yml被Spring ApplicationContext的父类加载，这个类先于加载application.yml的ApplicatonContext启动。
