package org.nbu.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.nbu.entities.Task;
import org.nbu.services.TaskService;
import org.nbu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/addTask")
    public String taskForm(String email, Model model, HttpSession session) {
        // TODO: extend so tasks are assigned to couriers from the customer which wants
        //  his order to be delivered
        session.setAttribute("email", email);
        model.addAttribute("task", new Task());
        return "views/taskForm";

    }

    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session) {
        // TODO: extend so tasks are assigned to couriers from the customer which wants
        //  his order to be delivered
        if (bindingResult.hasErrors()) {
            return "views/taskForm";
        }
        String email = (String) session.getAttribute("email");
        taskService.addTask(task, userService.findOne(email));

        return "redirect:/users";
    }

    @GetMapping("/showCustomerTask")
    public String taskCustomerForm(String email, Model model, HttpSession session) {
        // TODO: implement with a form so the customer can request task for delivery
        //  from a courier and office
        return "";
    }

    @GetMapping("/showCustomerTasks")
    public String showCustomerTasks(String email, Model model, HttpSession session) {
        // TODO: implement so the customer can see all the requested deliveries
        return "";
    }

    @PostMapping("/showCustomerTask")
    public String taskCustomer(String email, Model model, HttpSession session) {
        // TODO: implement with a form so the customer can request task for delivery
        //  from a courier and office
        return "";
    }

    @GetMapping("/showCourierTask")
    public String taskCourierForm(String email, Model model, HttpSession session) {
        // TODO: implement with a form so the courier can accept or decline a task
        //  for delivery from a customer
        return "";
    }

    @GetMapping("/showCourierTasks")
    public String showCourierTasks(String email, Model model, HttpSession session) {
        // TODO: implement so the courier can list all requested tasks for deliveries from a customer
        return "";
    }

    @PostMapping("/showCourierTask")
    public String taskCourier(String email, Model model, HttpSession session) {
        // TODO: implement with a form so the courier can accept or decline a task
        //  for delivery from a customer
        return "";
    }
}
