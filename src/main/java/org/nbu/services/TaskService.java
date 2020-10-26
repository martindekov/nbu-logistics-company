package org.nbu.services;

import java.util.List;

import org.nbu.entities.Task;
import org.nbu.entities.User;
import org.nbu.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User customer, User employee) {
        task.setCustomer(customer);
        task.setEmployee(employee);
        taskRepository.save(task);
    }

    public List<Task> findEmployeeTask(User user) {

        return taskRepository.findByEmployee(user);
    }

    public List<Task> findCustomerTask(User user) {

        return taskRepository.findByCustomer(user);
    }

    /**
     * Owner can see all delivery tasks
     */
    public List<Task> findOwnerTask(User user) {

        return taskRepository.findAll();
    }
}
