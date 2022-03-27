package com.example.JavaAssignment.service;

import com.example.JavaAssignment.models.Greetings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends CrudRepository <Greetings, Integer>{
    
}
