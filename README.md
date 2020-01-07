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
 
 # 2020/1/7 9:50
 - 服务雪崩：多个微服务之间调用的时候例如A调用B和C，BC调用其他，这就是所谓的扇出，如果扇出的链路上某个
 微服务的调用响应时间过长或不可用，对微服务的调用就会出现占用越来越多的资源，最后导致“雪崩效应”发生
 
 - 对于高流量的应用，单一的后端以来可能回调之所有服务器长的所有资源在几秒内饱和。更严重的是，这些应用还
 会导致服务之间的延迟增加，备份队列，线程和其他系统资源紧张，导致整个系统发生级联故障，进而需要对故障和延迟
 进行隔离和管理，以便单个依赖关系的失败，不会导致整个系统的瘫痪
 
 - Hystrix是一个用于处理分布式系统的延迟和容错的开源库，用于服务熔断、降级、限流、实时监控
 - 服务熔断：熔断机制是对应雪崩效应的一种微服务链路保护机制（快速返回错误 ）
 - 服务降级：是在客户端实现的，与服务端没关系。
 - 2.让客户端在服务端不可用时也会获得提示信息而不会挂起耗死服务器
