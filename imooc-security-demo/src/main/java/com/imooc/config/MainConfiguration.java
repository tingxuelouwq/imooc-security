package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @类名: MainConfiguration<br />
 * @包名：com.imooc.config<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/10 22:18<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
@Configuration
public class MainConfiguration {
    @Bean
    public TaskExecutor myTaskExecutor() {
        ThreadPoolTaskExecutor myTaskExecutor = new ThreadPoolTaskExecutor();
        myTaskExecutor.setCorePoolSize(5);
        myTaskExecutor.setMaxPoolSize(10);
        myTaskExecutor.setQueueCapacity(20);
        return myTaskExecutor;
    }
}
