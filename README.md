# springcloud
spring cloud demo 
spring-my-eureka-server
这里是注册中心
spring-my-eureka-server-discovery
这里是服务提供者1
spring-my-eureka-server-discovery
这里是服务提供者2
服务提供者一共两个，搭建成集群
spring-my-eureka-service-feign
这里是消费端，负载均衡，feign默认是开启ribbon功能的，所以建议开发者采用feign模式
spring-my-eureka-service-ribbon
这里是消费端，负载均衡
这里的消费端我们加入了hystrix，增加熔断功能
spring-my-hystrix
这里是服务监控，但是只能监控单个服务
spring-my-turbine 
这里是服务监控，可以监控集群，也可以监控单个实例
