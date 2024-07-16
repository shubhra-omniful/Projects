package com.masai.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
}
