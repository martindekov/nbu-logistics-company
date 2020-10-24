package org.nbu.repositories;

import java.util.List;

import org.nbu.entities.Task;
import org.nbu.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);

}
