package com.cookBook.api.model.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cookBook.api.model.entity.Rol;
import com.cookBook.api.model.entity.UserModel;

/**
 * LoadDatabase
 */
@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        UserModel bilbo = new UserModel("Bilbo", "admin", "Bilbo Baggins", Rol.admin);
        UserModel frodo = new UserModel("Frodo", "1234", "Frodo Baggins", Rol.user); 

        repository.save(frodo);
        repository.save(bilbo);

        return args -> {
            log.info("Preloading " + bilbo.getName());
            log.info("Preloading " + frodo.getName());
        };
    }
}