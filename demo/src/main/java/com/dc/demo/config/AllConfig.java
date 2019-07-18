package com.dc.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.dc.demo.other.MvcInterceptor;
import com.dc.demo.other.MyConverter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.dc.demo.service", "com.dc.demo.batch", "com.dc.demo.controller"})
@DubboComponentScan("com.dc.demo.service")
@MapperScan("com.dc.demo.dao")
public class AllConfig implements WebMvcConfigurer {

    /**
     * datasource
     *
     */

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    // 注册事务管理器在容器中
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(druid());
    }


    /**
     * mongo,config
     *
     */
    @Bean
    public MongoClient client() {
        return new MongoClient(new ServerAddress("120.79.182.70", 27017));
    }

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(client() , new MongoClientURI("mongodb://localhost/test").getDatabase());
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) {
        return new MongoTemplate(mongoDbFactory);
    }


    /**
     * mvc,config
     *
     */

    // 把自定义拦截器注册到容器中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // .addPathPatterns()  .excludePathPatterns() 拦截和排除;

        List<String> path = new ArrayList<>();
        path.add("/js/**");
        path.add("/bootstrap/**");
        registry.addInterceptor(mvcInterceptor())
                .excludePathPatterns(path)
                .addPathPatterns("/**");
    }

    // 把自定义转换器注册到容器中
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(myConverter());
    }

    // 自定义页面与访问路径映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // addViewController url访问路径   setViewName 映射到页面路径
        registry.addViewController("/test").setViewName("/test");
        registry.addViewController("/").setViewName("/index");
    }

    @Bean
    public MvcInterceptor mvcInterceptor() {
        return new MvcInterceptor();
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }

    @Bean
    public MyConverter myConverter() {
        return new MyConverter();
    }


    /**
     * rabbitmq,config
     *
     */

    @Bean
    public MessageConverter messageConverter() {
        return new MappingJackson2MessageConverter();
    }

    // 容器中注入链接工厂，spring
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("120.79.182.70:5672");
        return connectionFactory;
    }

    // 容器中注入rabbitTemplate
    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }


    /**
     * redis,config
     *
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jsonRedisSerializer.setObjectMapper(om);
//        template.setDefaultSerializer(jsonRedisSerializer);
        template.setValueSerializer(jsonRedisSerializer);
        template.setKeySerializer(jsonRedisSerializer);
        return template;
    }
}
