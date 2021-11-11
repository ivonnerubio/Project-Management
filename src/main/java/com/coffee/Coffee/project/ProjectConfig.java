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

            Project green = new Project(
                    "Green",
                    "Energy",
                    "Open",
                    "Iceland",
                    LocalDate.of(2021, 11, 9),
                    LocalDate.of(2025, 12, 31),
                    "Green Technologies"
            );

            Project sheldon = new Project(
                    "Sheldon",
                    "Physics",
                    "Open",
                    "California",
                    LocalDate.of(2021, 11, 10),
                    LocalDate.of(2021, 12, 31),
                    "Big Bang Sciences"
            );

            repository.saveAll(
                    List.of(skywalker, green, sheldon)
            );
        };
    }

}

