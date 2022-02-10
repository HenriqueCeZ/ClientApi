package com.example.springboot.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.springboot.controller.dto.ServiceDTO;
import com.example.springboot.model.Client;
import com.example.springboot.model.Service;
import com.example.springboot.repository.ClientRepository;
import com.example.springboot.repository.ServiceRepository;
import com.example.springboot.util.BigDecimalConvert;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ServiceController {
    private final ClientRepository clientRepository;
    private final ServiceRepository repository;
    private final BigDecimalConvert bigDecimalConvert;


    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) 
    public Service save(@RequestBody @Valid ServiceDTO dto){
       LocalDate date = LocalDate.parse(dto.getData(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       Integer idClient = dto.getIdCliente();
       Client client = clientRepository.findById(idClient).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));
        Service service = new Service();
        service.setDescription(dto.getDescricao());
        service.setData(date);
        service.setClient(client);
        service.setValor(bigDecimalConvert.converter(dto.getPreco()));


        return repository.save(service);
    }

    @GetMapping
    public List<Service> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ) {
        return repository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }
    
}
