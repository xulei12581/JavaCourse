必做题1:
  第一种方式通过XML装配Bean 创建Spring配置文件beans.xml装配Bean  在项目的resource目录下
  第二种自动装配 在controller中使用@AutoWired   在项目的controller文件中
  第三种是通过@Repository注解的方式装配bean     在项目的serviceImpl中
  
必做题2:
  在property目录下  启动类加了测试自动装配的例子 Starter没看懂是什么意思 是install一下自动装配的类然后通过pom依赖引用到项目测试吗
  
必做题3
  com.example.demo.dao.JdbcCurd.java
  (1)使用 JDBC 原生接口，实现数据库的增删改查操作。
  (2)使用事务，PrepareStatement 方式，批处理方式，改进上述操作。
  
  在application.yml下面配置了Hikari
  (3)配置 Hikari 连接池，改进上述操作
