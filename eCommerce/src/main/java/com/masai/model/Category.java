package com.masai.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Please enter the category name.")
    private String name;
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> products = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Image>images= new ArrayList<>();

}
