package org.nbu.entities;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * All accounts are user type accounts. The difference between EMPLOYEE, CUSTOMER
 * and OWNER is only in the role which can be specified by string for authorization purposes.
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;
    @NotEmpty
    private String name;
    @Size(min = 4)
    private String password;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Task> tasksAsEmployee;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Task> tasksAsCustomer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")})
    private List<Role> roles;

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
