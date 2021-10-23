必做题1:写代码实现 Spring Bean 的装配，方式越多越好（XML、Annotation 都可以）
  (1)通过 XML 装配 Bean
	
  (2)通过 Java 代码配置 Bean
  (3))自动化装配 Bean
  第一种方式通过XML装配Bean 创建Spring配置文件beans1.xml装配Bean
  第二种自动装配，就是将一个Bean自动的注入到到其他Bean的Property中 我这边写在了xml中 在实际的项目中使用@AutoWired即可
  第三种是通过注解的方式配置Bean 也就是实际项目中从controller层到mapper层都在使用的注解  
  @Component:描述spring bean
  @Repository:标识dao层的bean
  @Service:标识业务层的bean
  @Controller:标识控制器的bean
  @Autowired:对bean具体属性变量与方法标识
  @Resource:与@Autowired相似
  
