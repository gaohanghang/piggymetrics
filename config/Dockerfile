# 指定镜像基于java:8-jre 镜像创建
FROM java:8-jre
# 设置该镜像的作者
MAINTAINER Alexander Lukyanchikov <sqshq@sqshq.com>

# 复制文件指令。它有两个参数<source>和<destination>。destination是容器内的路径。source可以是URL或者是启动配置上下文中的一个文件
ADD ./target/config.jar /app/
# 提供了容器默认的执行命令。 Dockerfile只允许使用一次CMD指令。 使用多个CMD会抵消之前所有的指令，只有最后一个指令生效
CMD ["java", "-Xmx200m", "-jar", "/app/config.jar"]

# 健康检查 interval:间隔时间  timeout:超时时间 0:健康 1:不健康
HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8888/actuator/health || exit 1

# 让Docker暴露容器的端口号
EXPOSE 8888








