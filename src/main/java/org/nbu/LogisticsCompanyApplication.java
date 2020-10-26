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
            // Default owner account this account will be the only account capable of listing all
            // tasks (for delivery), clients and employees. This should not be deleted.
            User newOwner = new User("owner@mail.com", "Owner", "123456");
            userService.createOwner(newOwner);

            // TODO: Delete this account is created so we can do logic with tasks
            User newCustomer = new User("customer@mail.com","Customer","123456");
            userService.createCustomer(newCustomer);

            // TODO: Delete this account is created so we can do logic with tasks
            User newEmployee = new User("employee@mail.com","Employee","123456");
            userService.createEmployee(newEmployee);
        }
    }
}
