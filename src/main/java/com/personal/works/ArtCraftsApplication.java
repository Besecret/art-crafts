package com.personal.works;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.personal.works.mapper")
public class ArtCraftsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtCraftsApplication.class, args);
	}

}
