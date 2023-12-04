package com.csu.cs.week12.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            UserInfo mariam = new UserInfo(
                    "Mariam",
                    "510-555-5555",
                    Boolean.TRUE
            );
            UserInfo alex = new UserInfo(
                    "Alex",
                    "510-555-5535",
                    Boolean.FALSE
            );

            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }
}
