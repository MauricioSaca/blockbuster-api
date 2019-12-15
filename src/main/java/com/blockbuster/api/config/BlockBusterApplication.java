package com.blockbuster.api.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.blockbuster.api*" })
@EntityScan(basePackages = { "com.blockbuster.api.models" })
@EnableJpaRepositories("com.blockbuster.api.repository")
public class BlockBusterApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BlockBusterApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BlockBusterApplication.class, args);
	}

}
