package com.example.springboot.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



import lombok.Data;

@Entity
@Data
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length =150)
    private String description;


    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @Column
    private BigDecimal valor;

    @Column
    private LocalDate data;
    
}
