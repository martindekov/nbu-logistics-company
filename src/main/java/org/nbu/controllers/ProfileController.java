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
        String email = principal.getName();
        User user = userService.findOne(email);
        model.addAttribute("user", user);

        return "views/profile";
    }
}
