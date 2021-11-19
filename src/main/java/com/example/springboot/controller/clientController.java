package com.example.springboot.controller;

import com.example.springboot.model.Client;
import com.example.springboot.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/clientes")
public class clientController {
    
   
    private final ClientRepository repository;

    @Autowired
    public clientController(ClientRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return repository.save(client);
    }

    @GetMapping("{id}")
    public Client searchClient(@PathVariable Integer id){
        return repository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
  @GetMapping("/search")
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
         }).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
   
    }
    

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void update(@PathVariable Integer id, @RequestBody Client clientUpdate){
        repository.findById(id).map(client ->{
            clientUpdate.setId(client.getId()); //as atualizações vão ser setadas para o clientid
            clientUpdate.setRegisterDate(client.getRegisterDate());
           return repository.save(clientUpdate); 

        }).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
