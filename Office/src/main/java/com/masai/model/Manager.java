package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(exclude = {"employees","office"})
@Data
@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double salary;
    @Embedded
    private Address address;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private Set<Employee> employees = new HashSet<>();
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Office office;
}
