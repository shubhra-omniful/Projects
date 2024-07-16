package com.masai.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(exclude = {"managers","employees"})
@Data
@Entity
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Embedded
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "office")
    private Set<Manager> managers=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "office")
    private Set<Employee> employees = new HashSet<>();

}
