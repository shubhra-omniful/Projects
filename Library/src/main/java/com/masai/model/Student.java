package com.masai.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roll;
    private String name;
    @Embedded
    private  Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<Book> books = new HashSet<>();
}
