package com.coffee.Coffee.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;


@Configuration
public class ProjectConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProjectRepository repository){
        return args ->{
            Project skywalker = new Project(
                        "Skywalker",
                        "Development",
                        "Open",
                        "USA",
                        LocalDate.of(2021, 8, 04),
                        LocalDate.of(2025, 3, 24),
                        "Star Wars Industries"
                    );


            repository.saveAll(
                    List.of(skywalker)
            );
        };
    }

}

