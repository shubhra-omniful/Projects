package com.masai.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Please enter the product name.")
    private String name;

    @NotNull(message = "Please enter a description for the product.")
    private String description;

    @NotNull(message = "Please enter the sale price of the product.")
    private Double salePrice;

    @NotNull(message = "Please enter the market price of the product.")
    private Double marketPrice;

    @NotNull(message = "Please specify the type of the product.")
    private String type;

    private Boolean active;

    @Transient
    @NotNull(message = "Please enter the category ID of the product.")
    private Integer categoryID;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Image> images = new ArrayList<>();

}
