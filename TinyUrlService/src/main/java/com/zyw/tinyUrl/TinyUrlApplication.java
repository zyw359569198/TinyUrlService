package com.zyw.tinyUrl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.zyw.tinyUrl.mapper")
@EnableTransactionManagement
public class TinyUrlApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TinyUrlApplication.class, args);
	}
}
