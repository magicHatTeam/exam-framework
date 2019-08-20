## boss-bes-awsl-common
这是博思考试系统的公用模块

**dev是开发版本**

其中boss-bes-spring-cloud-starter是整体打包的项目（用于引用其他模块）

使用时请`maven install`

maven 依赖
```xml
<dependency>
    <groupId>com.bosssoft.cloud</groupId>
    <artifactId>boss-bes-spring-cloud-starter</artifactId>
    <version>1.0</version>
</dependency>
```

其中可以单独引用的模块为**boss-bes-core-data**
```xml
<dependency>
    <groupId>com.bosssoft.cloud</groupId>
    <artifactId>boss-bes-core-data</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```