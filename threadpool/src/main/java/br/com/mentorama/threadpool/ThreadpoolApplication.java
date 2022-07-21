package br.com.mentorama.threadpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = {"br.com.mentorama.threadpool"})
public class ThreadpoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThreadpoolApplication.class, args);
	}

}
