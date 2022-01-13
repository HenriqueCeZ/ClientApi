package com.example.springboot.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
public class ServiceDTO {
    private String descricao;
    private String preco;
    private String data;
    private Integer idCliente;
   
}
