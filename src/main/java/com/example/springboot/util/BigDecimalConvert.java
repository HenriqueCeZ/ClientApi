package com.example.springboot.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class BigDecimalConvert {


    public BigDecimal converter(String value){

        if (value== null){
            return null; 
        }
        value = value.replace(".", "").replace(",",".");
        return new BigDecimal(value);
    }
    
}
