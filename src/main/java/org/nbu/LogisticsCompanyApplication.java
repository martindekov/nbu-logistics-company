package org.nbu;

import org.nbu.entities.User;
import org.nbu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogisticsCompanyApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(LogisticsCompanyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        {
            User newOwner = new User("admin@mail.com", "Admin", "123456");
            userService.createOwner(newOwner);
        }
    }
}
