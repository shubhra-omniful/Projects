package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(exclude = {"manager","office"})
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double salary;
    @Embedded
    private Address address;
    @ManyToOne(cascade = CascadeType.ALL)
    private Manager manager;
    @ManyToOne(cascade = CascadeType.ALL)
    private Office office;
}
