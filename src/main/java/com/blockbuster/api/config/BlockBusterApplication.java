package com.blockbuster.api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.blockbuster.api.enums.RoleEnum;
import com.blockbuster.api.models.Authorities;
import com.blockbuster.api.models.UserPrincipal;
import com.blockbuster.api.repository.AuthoritiesRepository;
import com.blockbuster.api.repository.UserPrincipalRepository;

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

	@Bean
	CommandLineRunner initDatabase(UserPrincipalRepository userRepository,
			AuthoritiesRepository authoritiesRepository) {
		UserPrincipal adminUser = new UserPrincipal();
		String password = new BCryptPasswordEncoder().encode("admin");
		adminUser.setName("Mauricio");
		adminUser.setLastName("Saca");
		adminUser.setUsername("msaca");
		adminUser.setPassword(password);
		adminUser.setEmail("mauricio.saca@mh.gob.sv");
		adminUser.setEnabled(true);

		Authorities auth = new Authorities();
		auth.setUserPrincipal(adminUser);
		auth.setRole(RoleEnum.ADMIN);

		return args -> {
			userRepository.save(adminUser);
			authoritiesRepository.save(auth);
		};
	}

}
