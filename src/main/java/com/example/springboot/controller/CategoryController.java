package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.example.springboot.model.category.Category;
@RestController
@RequestMapping("/category")
public class CategoryController {
      
       @GetMapping("/list")
       public List<Category> listar(){
        
        Category cat1 =  new Category(1, "informática");
        Category cat2 = new Category(2, "Escritório");

        List<Category> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);

           return lista;
       }
}
