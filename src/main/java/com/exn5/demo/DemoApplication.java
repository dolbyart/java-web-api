package com.exn5.demo;


import com.exn5.demo.models.User;
import com.exn5.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return (args) -> {
            // save a few users

            if (Objects.isNull(userRepository.findByEmail("art@mail.ru")))
                userRepository.save(new User(UUID.randomUUID(), "Artour Graev", "1234", "art@mail.ru",null, new Date()));
            if (Objects.isNull(userRepository.findByEmail("javi@gmail.com")))
            userRepository.save(new User(UUID.randomUUID(), "Javier Calderon", "1234", "javi@gmail.com", null, new Date()));

            // fetch all user
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User users : userRepository.findAll()) {
                log.info(users.toString());
            }
            log.info("");

            // fetch user by mail
            log.info("User found with findByEmail('javi@gmail.com'):");
            log.info("--------------------------------------------");
            log.info(userRepository.findByEmail("javi@gmail.com").toString());
            log.info("");
        };
    }
}
