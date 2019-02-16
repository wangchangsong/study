package com.wcs.styudy.biz.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * TODO 类描述
 *
 * @author pro
 */
@Component
public class CacheService {

    public void buildCache() throws ExecutionException {

        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(100) // 设置缓存的最大容量
                .expireAfterWrite(10, TimeUnit.SECONDS) // 设置缓存在写入一分钟后失效
                .concurrencyLevel(10) // 设置并发级别为10
                .recordStats() // 开启缓存统计
                .build();

        cache.put("key", "value");

        String value = cache.getIfPresent("key");
        System.out.println(value);

        Object getValue = cache.get("key", new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "value";
            }
        });
        System.out.println(getValue);
    }

    @PostConstruct
    public void getValues() {

    }
}
