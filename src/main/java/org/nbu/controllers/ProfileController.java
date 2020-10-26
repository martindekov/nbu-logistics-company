package org.nbu.controllers;

import java.security.Principal;

import org.nbu.entities.User;
import org.nbu.services.TaskService;
import org.nbu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal) {
        // TODO: remove once the views below are implemented
        String email = principal.getName();
        User user = userService.findOne(email);

        //model.addAttribute("tasks", taskService.findUserTask(user));

        return "views/profile";
    }

    @GetMapping("/employeeProfile")
    public String showEmployeeProfilePage(Model model, Principal principal) {
        // TODO: implement view
        String email = principal.getName();
        User user = userService.findOne(email);

        model.addAttribute("tasks", taskService.findEmployeeTask(user));

        return "views/profile";
    }

    @GetMapping("/customerProfile")
    public String showCustomerProfilePage(Model model, Principal principal) {
        // TODO: implement view
        String email = principal.getName();
        User user = userService.findOne(email);

        model.addAttribute("tasks", taskService.findCustomerTask(user));

        return "views/profile";
    }

    @GetMapping("/ownerProfile")
    public String showOwnerProfilePage(Model model, Principal principal) {
        // TODO: implement view
        String email = principal.getName();
        User user = userService.findOne(email);

        model.addAttribute("tasks", taskService.findOwnerTask(user));

        return "views/profile";
    }

}
