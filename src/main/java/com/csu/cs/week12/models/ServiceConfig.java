package com.csu.cs.week12.models;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ServiceConfig {
    @Bean
    CommandLineRunner serviceConfigCommandLineRunner(ServiceRepository repository){
        return args -> {
            /*ServiceInfo mariam1 = new ServiceInfo(
                    9L,
                    null,
                    "Plumbing",
                    19.99
            );
            ServiceInfo mariam2 = new ServiceInfo(
                    9L,
                    null,
                    "Bathroom fixes",
                    29.99
            );
            ServiceInfo jeff1 = new ServiceInfo(
                    11L,
                    null,
                    "Plumbing",
                    25.99
            );
            ServiceInfo mark1 = new ServiceInfo(
                    13L,
                    null,
                    "Electric Installation & Upgrades",
                    25.99
            );
            ServiceInfo ben1 = new ServiceInfo(
                    15L,
                    null,
                    "Concrete floors & walls",
                    30.99
            );
            ServiceInfo dee1 = new ServiceInfo(
                    17L,
                    null,
                    "Painting",
                    29.99
            );
            ServiceInfo gabriela1 = new ServiceInfo(
                    19L,
                    null,
                    "Gardening",
                    19.99
            );


            repository.saveAll(
                    List.of(mariam1, mariam2, jeff1,
                            mark1, ben1,
                            dee1, gabriela1)
            );*/
        };
    }
}
