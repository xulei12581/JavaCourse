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
