package com.masai.model;

import jakarta.persistence.*;
import lombok.Data;

import java.net.URL;

@Data
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private URL url;
    private String title;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

}
