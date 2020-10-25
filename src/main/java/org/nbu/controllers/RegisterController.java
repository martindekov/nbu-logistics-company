package org.nbu.controllers;

import javax.validation.Valid;

import org.nbu.entities.Role;
import org.nbu.entities.User;
import org.nbu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {

        model.addAttribute("user", new User());
        return "views/registerForm";
    }

    /**
     * This is base the method which registers the user which can be employee or customer
     * Where owner can register office
     * Where customer can register tasks and assign them to office and employee
     */
    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "views/registerForm";
        }
        if (userService.isUserPresent(user.getEmail())) {
            model.addAttribute("exist", true);

            return "views/registerForm";
        }

        Role role = user.getRoles().get(0);
        if (role.getName().equalsIgnoreCase("employee")){
            userService.createEmployee(user);
        }else if (role.getName().equalsIgnoreCase("customer")) {
            userService.createCustomer(user);
            // TODO: return invalid in case other type of user is chosen
            //  this is optional as you should change the html in order for this to happen
        }

        return "views/success";
    }

    @GetMapping("/registerOffice")
    public String registerOfficeForm(@Valid User user, BindingResult bindingResult, Model model) {
        // TODO: implement to return registration view for office which should only
        //  be accessible by the owner which can register office
        return "";
    }

    @PostMapping("/registerOffice")
    public String registerOffice(@Valid User user, BindingResult bindingResult, Model model) {
        // TODO: implement saving the office information from the form above
        //  only owner should have access to this endpoint
        return "";
    }

}
