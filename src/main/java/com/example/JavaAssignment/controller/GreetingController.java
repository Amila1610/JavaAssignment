package com.example.JavaAssignment.controller;

import com.example.JavaAssignment.models.Greetings;
import com.example.JavaAssignment.service.GreetingRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/javaAssignment")
public class GreetingController {
    
   /* @Autowired
    private GreetingRepository greetingRepository;
    
    @GetMapping("/greetings")
    private List<Greetings> getAllGreetings(){
        return (List<Greetings>) greetingRepository.findAll();
    }
    
    @GetMapping("/greetings/{id}")
    public Optional<Greetings> getGreetingById(@PathVariable("id")Integer id){
        return greetingRepository.findById(id);
    }*/
}
