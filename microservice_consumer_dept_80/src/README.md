#### Ribbon简介
- 官方网址：https://github.com/Netflix/ribbon/wiki/Getting-Started
- 客户端 负载均衡 LB 
   集中式LB 硬件F5 nginx等
   进程式LB 代码实现Ribbon，集成在客户端
   - Ribbon是Netflix发布的开源项目，主要提供客户端的软件负载均衡算法（可实现自定义负载均衡算法）
   - Ribbon客户端提供一系列完整的配置项，如连接超时，重试等。在配置文件中列出load Balancer后面
   所有的机器，Ribbon会自动帮助你基于某种规则去链接这些机器
   
### Ribbon软负载均衡支持算法
 - RoundRobinRule   --------- 轮询(默认)
 - RandomRule ----------------随机
 - AvailabilityFilteringRule ------------ 会过滤掉由于多次访问故障而处于断路器跳闸状态的服务,还有并发
 的连接数量超过阈值的服务,然后对剩余的服务列表按轮询策略进行访问
 - WeightedResponseTimeRule ---------------根据平均的响应时间计算所有服务的权重,响应时间越快服务权重越大备选中的概率越高。
 刚启动时如果启动信息不足,则使用RoundRobinRule策略,等统计信息足够会切换到WeightedResponseTimeRule
 - RetryRule-------------先按照RoundRobinRule的策略获取服务,如果获取服务失败则在指定时间内会进行重试,获取可用的服务
 - BestAvailableRule---------------会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务,然后选择一个并发量小的服务
 - ZoneAvoidanceRule ---------------- 默认规则,符合判断server所在区域的性能和server的可用性选择服务器