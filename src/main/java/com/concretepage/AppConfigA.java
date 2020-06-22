package com.concretepage; 
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;
  
@Configuration
@ComponentScan("com.concretepage")
@EnableCaching
public class AppConfigA  {
    @Bean
    public CacheManager cacheManager() {
       GuavaCacheManager cacheManager = new GuavaCacheManager("mycache");
       CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
       .maximumSize(100)
       .expireAfterWrite(10, TimeUnit.MINUTES);
       cacheManager.setCacheBuilder(cacheBuilder);
       return cacheManager;
    }
}  
 