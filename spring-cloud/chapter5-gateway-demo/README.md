先启动 chapter5-gateway-service，也就是实际的service
再启动 chapter5-gateway-demo，也就是 gateway 本身
这里面网关：
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
和 web 有冲突：
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>

所以，这里面没法直接启动，换一个 IDEA，单独导入这个 gateway-demo 就行了
