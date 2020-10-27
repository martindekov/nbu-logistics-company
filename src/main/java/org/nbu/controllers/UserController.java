package org.nbu.controllers;

import org.nbu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model, @RequestParam(defaultValue = "") String name) {
        model.addAttribute("users", userService.findByName(name));
        return "views/listUsers";
    }

    @GetMapping("/editUser")
    public String editUserForm(String email, Model model, HttpSession session) {
        // TODO: extend this to return proper view covering the logic.
        //  The email parameter is the query string containing the edited user email
        session.setAttribute("email", email);
        return "views/list";
    }
}
