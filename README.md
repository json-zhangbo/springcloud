# springcloud
包好基本的spring cloud 项目
# <a href="https://github.com/json-zhangbo/springcloud/tree/master/spring-my-cloud/spring-my-eureka-service">spring-my-eureka-server</a></br>
这里是注册中心</br>
# spring-my-eureka-server-discovery</br>
这里是服务提供者1</br>
# spring-my-eureka-server-discovery2</br>
这里是服务提供者2</br>
服务提供者一共两个，搭建成集群</br>
# spring-my-eureka-service-feign</br>
这里是消费端，负载均衡，feign默认是开启ribbon功能的，所以建议开发者采用feign模式</br>
# spring-my-eureka-service-ribbon</br>
这里是消费端，负载均衡</br>
这里的消费端我们加入了hystrix，增加熔断功能</br>
# spring-my-hystrix</br>
这里是服务监控，但是只能监控单个服务</br>
# spring-my-turbine </br>
这里是服务监控，可以监控集群，也可以监控单个实例</br>

#作者：张波
QQ:329989580
