package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
