package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Client, Integer> {
    
}
