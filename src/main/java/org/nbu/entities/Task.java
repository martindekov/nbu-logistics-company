package org.nbu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * This class represents a task for delivery between customer and employee.
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String date;
    @NotEmpty
    private String startTime;
    @NotEmpty
    private String stopTime;
    @NotEmpty
    @Column(length = 1000)
    private String description;
    @Column(length = 1000)
    private String address;
    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_EMAIL", referencedColumnName="email")
    private User employee;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_EMAIL", referencedColumnName="email")
    private User customer;

    public Task(String date, String startTime, String stopTime, String description) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
    }
}
