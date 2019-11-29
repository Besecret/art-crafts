package com.personal.works;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.personal.works.mapper")
public class ArtCraftsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtCraftsApplication.class, args);
	}

}
