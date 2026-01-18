package com.bzdata.TataFneBackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import com.bzdata.TataFneBackend.role.Role;
import com.bzdata.TataFneBackend.role.RoleRepository;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableAsync
@SpringBootApplication
public class TataFneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TataFneBackendApplication.class, args);
	}
    @Bean
    public CommandLineRunner runner(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findByName("USER").isEmpty()) {
                roleRepository.save(Role.builder().name("USER").code("USER").build());
            }
        };
    }

}
