package com.example.springboot.controller;

import com.example.springboot.model.Client;
import com.example.springboot.repository.ClientRepository;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/clients")
@CrossOrigin("http://localhost:4200")
public class ClientController {
    
   
    private final ClientRepository repository;

    @Autowired
    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody @Valid Client client){
        return repository.save(client);
    }

    @GetMapping("{id}")
    public Client searchClient(@PathVariable Integer id){
        return repository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }
  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public List<Client> getAllClient() {
    return repository.findAll();
  }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        // repository.deleteById(id); um delete sem verificação
         repository.findById(id).map(client ->{
             repository.delete(client);
             return Void.TYPE;
         }).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
   
    }


    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid Client clientUpdate){
        repository.findById(id).map(client ->{
            client.setName(clientUpdate.getName());
            client.setCpf(clientUpdate.getCpf());
           return repository.save(client); 

        }).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

}
