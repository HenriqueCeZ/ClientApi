package com.example.springboot.repository;


import java.util.List;

import com.example.springboot.model.Service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

    
    @Query(" select s from Service s join s.client c " +
    " where upper( c.name ) like upper( :nome ) and MONTH(s.data) =:mes")
    List<Service> findByNomeClienteAndMes(
    @Param("nome") String nome, @Param("mes") Integer mes);
    
}
