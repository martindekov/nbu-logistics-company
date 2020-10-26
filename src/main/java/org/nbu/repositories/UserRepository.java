package org.nbu.repositories;

import java.util.List;

import org.nbu.entities.Role;
import org.nbu.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByNameLike(String name);

    List<User> findUserByRoles(Role role);

}
