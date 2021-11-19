package com.example.springboot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity; //dizer que é uma entidade jpa
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(name = "data_register")
    private LocalDate registerDate;


   
}
