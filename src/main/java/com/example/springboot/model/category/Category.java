package com.example.springboot.model.category;

import java.io.Serializable;


public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public Category(){
    }
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

  



    @Override
    public boolean equals(Object obj)
    {
          
    // checking if both the object references are 
    // referring to the same object.
    if(this == obj)
            return true;
          
        // it checks if the argument is of the 
        // type Geek by comparing the classes 
        // of the passed argument and this object.
        // if(!(obj instanceof Geek)) return false; ---> avoid.
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
          
        // type casting of the argument. 
        Category categoryController = (Category) obj;
          
        // comparing the state of argument with 
        // the state of 'this' Object.
        return (categoryController.name == this.name && categoryController.id == this.id);
    }
      
    @Override
    public int hashCode()
    {
    
        return this.id;
    }
    


 
    

}

