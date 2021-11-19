package com.example.springboot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity; //dizer que é uma entidade jpa
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)

    @NotEmpty(message = "{campo.name.obrigatorio}")
    private String name;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(name = "data_register", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate registerDate;

    @PrePersist
    public void prePersist() {
        setRegisterDate(LocalDate.now()); //antes de persistence no database uso seto a data atual
    }

    
   
}
