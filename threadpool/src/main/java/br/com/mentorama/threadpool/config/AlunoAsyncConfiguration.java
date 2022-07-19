package br.com.mentorama.threadpool.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;

@Configuration
public class AlunoAsyncConfiguration {

    @Bean
    public Executor executorService(){

        return ForkJoinPool.commonPool();
    }

    @Bean
    public Executor customThreadPool(){
       final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(6);
        executor.setQueueCapacity(10);
        return  executor;
    }
}
