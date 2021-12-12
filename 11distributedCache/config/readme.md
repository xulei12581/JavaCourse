主从复制
  启动配置
  redis-server redis6379.conf
  redis-server redis6380.conf
  slaveof 127.0.0.1 6379

sentinel 高可用
  启动配置
  redis-server redis6379.conf
  redis-server redis6380.conf
  redis-sentinel sentine0.conf
  redis-sentinel sentinel.conf
  把6379服务停掉 6380从slave切换为master info也显示为master set a 111也可以执行
  如果再启动6379服务 则6379服务成为6380的slave
Cluster 集群
  搭建Redis Cluster主要步骤
    1.配置开启节点
    2.meet
    3.指派槽
    4.主从关系分配
  环境准备
    两台虚拟机，IP地址分别为：192.168.81.100和192.168.81.101
	使用两台虚拟机的7000,7001,7002端口搭建三主三从的Redis Cluster
    其中192.168.81.100主机三个端口启动的Redis Server为主节点
    192.168.81.101主机三个端口启动的Redis Server为从节点
  具体操作
    192.168.81.100虚拟机上操作
    redis-server /opt/config/redis_7000.conf               
    redis-server /opt/config/redis_7001.conf                          
    redis-server /opt/config/redis_7002.conf 
    192.168.81.101虚拟机上操作 配置文件与100虚拟机一样
	redis-server /opt/config/redis_7000.conf               
    redis-server /opt/config/redis_7001.conf                          
    redis-server /opt/config/redis_7002.conf
	在192.168.81.100虚拟机上查看cluster节点的信息
	redis-cli -p 7000
	cluster nodes
	cluster info
  在192.168.81.100上执行meet操作
    # 通过7000端口的redis server向7001端口的redis server发送meet操作
    redis-cli -p 7000 cluster meet 127.0.0.1 7001
	# 通过7000端口运行的redis server查看cluster的节点信息，已经添加7001端口运行的redis server,且都为master节点
	redis-cli -p 7000 cluster nodes
	redis-cli -p 7001 cluster nodes
	redis-cli -p 7002 cluster nodes
	# 向7002端口运行的redis server发送meet操作
	redis-cli -p 7000 cluster meet 127.0.0.1 7002
	redis-cli -p 7001 cluster nodes
	redis-cli -p 7002 cluster nodes
	向192.168.81.101:7002端口运行的redis server执行meet操作
	redis-cli -p 7000 cluster meet 192.168.81.101 7002
	向192.168.81.101:7000端口运行的redis server执行meet操作
	redis-cli -p 7000 cluster meet 192.168.81.101 7000
	向192.168.81.101:7001端口运行的redis server执行meet操作
	redis-cli -p 7000 cluster meet 192.168.81.101 7001
	redis-cli -p 7000 cluster nodes
	# 查看集群中的节点信息
	redis-cli -p 7002 cluster nodes
	# 查看集群相关的信息
	redis-cli -p 7002 cluster info
  在192.168.81.101虚拟机上查看cluster的信息
    redis-cli -p 7000 cluster nodes
	redis-cli -p 7001 cluster nodes
	redis-cli -p 7002 cluster nodes
	redis-cli -p 7002 cluster info
  在192.168.81.100虚拟机上编写脚本，完成分配slot
    # 运行add_slots.sh脚本，把0到5461号槽分配给192.168.81.100:7000的redis server节点
    sh add_slots.sh 0 5461 7000
	# 查看cluster集群的信息
	redis-cli -p 7000 cluster info
	# 查看集群中节点的信息
	redis-cli -p 7000 cluster nodes
    redis-cli -p 7002 cluster nodes
    # 运行add_slots.sh脚本，把5462号到10922号槽分配给7001端口运行的redis server	
    sh add_slots.sh 5462 10922 7001   
	# 运行add_slots.sh脚本，把10923号到16383号槽分配给7002端口运行的redis server	
    sh  add_slots.sh 10923 16383 7002 
    # 查看集群的节点信息	
 	redis-cli -p 7000 cluster nodes  
	# 查看集群的信息
    redis-cli -p 7000 cluster info	
	redis-cli -p 7001 cluster info
    redis-cli -p 7002 cluster info
    #进入7000端口
    redis-cli -p 7000
	# 成功向集群中写入数据
    set hello world  
    # 获取集群的配置信息	
    config get cluster* 	
  在192.168.81.101虚拟机上操作
    # 查看集群的节点信息，都是master
    redis-cli -p 7002 cluster nodes
	# 使192.168.81.101:7000端口运行的redis server做为192.168.81.100:7000端口运行的redis server的master
	redis-cli -p 7000 cluster replicate d20aa403c5d7d9507adcc4ef6132c14f3c9486ed        
    redis-cli -p 7001 cluster replicate 45d79e730593df3216a4236a19c21ff601949449
	redis-cli -p 7002 cluster replicate e5ea887c98e79ef2b2205d6cc1d7ac5cfe936d9a 
	# 查看集群的节点信息
	redis-cli -p 7002 cluster nodes   
    # 查看集群的槽与节点的关系	
    redis-cli -p 7002 cluster slots  
  向集群中写入数据
    redis-cli -c -p 7000
    set hello world
