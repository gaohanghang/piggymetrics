

## spring-boot-starter-parent 作用
```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.3.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
```

> 作用

- 定义了 Java 编译版本为 1.8 。
- 使用 UTF-8 格式编码。
- 继承自 spring-boot-dependencies，这个里边定义了依赖的版本，也正是因为继承了这个依赖，所以我们在写依赖时才不需要写版本号。
- 执行打包操作的配置。
- 自动化的资源过滤。
- 自动化的插件配置。
- 针对 application.properties 和 application.yml 的资源过滤，包括通过 profile 定义的不同环境的配置文件，例如 application-dev.properties 和 application-dev.yml。


## dependencies 和 dependencyManagement 区别

```
    <dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
```

区别

dependencies 即使在子项目中不写该依赖项，那么子项目仍然会从父项目中继承该依赖项（全部继承）

dependencyManagement 里只是声明依赖，并不实现引入，因此子项目需要显示的声明需要用的依赖。如果不在子项目中声明依赖，是不会从父项目中继承下来的；只有在子项目中写了该依赖项，并且没有指定具体版本，才会从父项目中继承该项，并且 version 和 scope 都读取自父 pom; 另外如果子项目中指定了版本号，那么会使用子项目中指定的jar版本。

https://zhuanlan.zhihu.com/p/31020263
