package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(exclude = "courses")
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true, nullable = false)
    private Integer roll;
    private String name;
    private Double marks;
    @Embedded
    private Address address;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL )
    private Set<Course> courses = new HashSet<>();

}
