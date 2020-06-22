package com.concretepage; 
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;
  
@Configuration
@ComponentScan("com.concretepage")
@EnableCaching
public class AppConfigB  {
    @Bean
    public CacheManager cacheManager() {
       SimpleCacheManager cacheManager = new SimpleCacheManager();
       GuavaCache guavaCache1 = new GuavaCache("book", CacheBuilder.newBuilder()
    		   .maximumSize(50).build());
       GuavaCache guavaCache2 = new GuavaCache("bookstore", CacheBuilder.newBuilder()
    		   .maximumSize(100).expireAfterAccess(5, TimeUnit.MINUTES).build());
       cacheManager.setCaches(Arrays.asList(guavaCache1, guavaCache2));
       return cacheManager;
    }
}  
 