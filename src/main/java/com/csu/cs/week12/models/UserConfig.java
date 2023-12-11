package com.csu.cs.week12.models;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            /*UserInfo mariam = new UserInfo(
                    "Mariam",
                    "510-555-5001",
                    Boolean.TRUE,
                    "abc"
            );
            UserInfo alex = new UserInfo(
                    "Alex",
                    "510-555-5002",
                    Boolean.FALSE,
                    "abc"
            );
            UserInfo jeff = new UserInfo(
                    "Jeff",
                    "510-555-5003",
                    Boolean.TRUE,
                    "abc"
            );
            UserInfo jessica = new UserInfo(
                    "Jessica",
                    "510-555-5004",
                    Boolean.FALSE,
                    "abc"
            );
            UserInfo mark = new UserInfo(
                    "Mark",
                    "510-555-5005",
                    Boolean.TRUE,
                    "abc"
            );
            UserInfo amelia = new UserInfo(
                    "Amelia",
                    "510-555-5006",
                    Boolean.FALSE,
                    "abc"
            );
            UserInfo ben = new UserInfo(
                    "Ben",
                    "510-555-5007",
                    Boolean.TRUE,
                    "abc"
            );
            UserInfo charlie = new UserInfo(
                    "Charlie",
                    "510-555-5008",
                    Boolean.FALSE,
                    "abc"
            );
            UserInfo dee = new UserInfo(
                    "Dee",
                    "510-555-5009",
                    Boolean.TRUE,
                    "abc"
            );
            UserInfo frank = new UserInfo(
                    "Frank",
                    "510-555-5010",
                    Boolean.FALSE,
                    "abc"
            );
            UserInfo gabriela = new UserInfo(
                    "Gabriela",
                    "510-555-5011",
                    Boolean.TRUE,
                    "abc"
            );
            UserInfo harry = new UserInfo(
                    "Harry",
                    "510-555-5012",
                    Boolean.FALSE,
                    "abc"
            );

            repository.saveAll(
                    List.of(mariam, alex, jeff, jessica,
                            mark, amelia, ben, charlie,
                            dee, frank, gabriela, harry)
            );*/
        };
    }
}
