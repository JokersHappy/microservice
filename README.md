# microservice
# author 陈伟
微服务架构

#### Eureka服务治理
 # 2019/11/29 17:25
 - Netflix在设计Eureka时遵循AP原则
 - 遗留问题：localhost:8001/info 无法显示version、artifactId
 - 增加Info展示
 
# 2019/12/13 17:23
- 增加Eureka集群落地实现


# 2019/12/16 15:55
 - 增加Ribbon集成，进行微服务访问完善 
 
 - 增加微服务集群provider
 
# 2019/12/18 14:35
- 增加ribbon自定义负载均衡算法配置类

# 2019/12/27 11:00
- 开始Feign学习
 Feign是一个声明式的Web服务客户端，使得编写Web服务客户端变得非常容易
 只需要创建接口，然后在上面添加注解即可
 可以简化Ribbon自动封装服务调用客户端的开发量