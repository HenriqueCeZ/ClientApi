package com.example.springboot.repository;

import com.example.springboot.model.Service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    
}
