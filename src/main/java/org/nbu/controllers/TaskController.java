package org.nbu.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.nbu.entities.Task;
import org.nbu.entities.User;
import org.nbu.services.TaskService;
import org.nbu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/addTask")
    public String taskForm(Model model) {
        List<User> employees = userService.findEmployees();
        model.addAttribute("task", new Task());
        model.addAttribute("employees", employees);
        return "views/taskForm";

    }

    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "views/taskForm";
        }

        String loggedUserEmail = getEmailFromSession(session);
        User customer = userService.findOne(loggedUserEmail);
        User employee = userService.findOne(task.getEmployee().getEmail());
        taskService.addTask(task, customer, employee);

        return "redirect:/users";
    }

    @GetMapping("/customerTask")
    public String taskCustomerForm(String email, Model model, HttpSession session) {
        // TODO: implement with a form so the customer can request task for delivery
        //  from employee and office
        return "";
    }

    @GetMapping("/listCustomerTasks")
    public String listCustomerTasks(Model model, HttpSession session) {
        String loggedUserEmail = getEmailFromSession(session);
        User customer = userService.findOne(loggedUserEmail);
        List<Task> employeeTasks = taskService.findCustomerTask(customer);
        model.addAttribute("tasks", employeeTasks);
        return "views/listCustomerTasks";
    }

    @PostMapping("/customerTask")
    public String taskCustomer(String email, Model model, HttpSession session) {
        // TODO: implement with a form so the customer can request task for delivery
        //  from employee and office
        return "";
    }

    @GetMapping("/employeeTask")
    public String taskEmployeeForm(String email, Model model, HttpSession session) {
        // TODO: implement with a form so the employee can accept or decline a task
        //  for delivery from a customer
        return "";
    }

    @GetMapping("/listEmployeeTasks")
    public String listEmployeeTasks(Model model, HttpSession session) {
        String loggedUserEmail = getEmailFromSession(session);
        User employee = userService.findOne(loggedUserEmail);
        List<Task> employeeTasks = taskService.findEmployeeTask(employee);
        model.addAttribute("tasks", employeeTasks);
        return "views/listEmployeeTasks";
    }

    @PostMapping("/employeeTask")
    public String taskEmployee(String email, Model model, HttpSession session) {
        // TODO: implement with a form so the courier can accept or decline a task
        //  for delivery from a customer
        return "";
    }

    @GetMapping("/listAllTasks")
    public String listAllTasks(Model model) {
        List<Task> allTasks = taskService.findOwnerTask();
        model.addAttribute("tasks", allTasks);
        return "views/listAllTasks";
    }

    private String getEmailFromSession(HttpSession session) {
        SecurityContextImpl token = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        org.springframework.security.core.userdetails.User loggedUser =
                (org.springframework.security.core.userdetails.User) token.getAuthentication().getPrincipal();
        return loggedUser.getUsername();
    }
}
