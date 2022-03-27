package com.example.JavaAssignment.controller;

import com.example.JavaAssignment.models.Greetings;
import com.example.JavaAssignment.service.GreetingRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("/greetings")
public class GreetingController {
    
   @Autowired
    GreetingRepository greetingRepository;
   
   @RequestMapping("/")
   public String home(){
       return "home.html";
   }
   
  /* @GetMapping("/getGreetings")
    private List<Greetings> getAllGreetings(){
        return (List<Greetings>) greetingRepository.findAll();
    }
           
    @GetMapping("/greetings/{id}")
    public Optional<Greetings> getGreetingById(@PathVariable("id")Integer id){
        return greetingRepository.findById(id);
    }
    */
    public Greetings getGreetingByLang(String lang){
        List<Greetings> greetings= (List<Greetings>) greetingRepository.findAll();
        for(Greetings greeting:greetings)
            if(greeting.getLanguage().equalsIgnoreCase(lang))
                return greeting;
        return null;
    }
    
    @RequestMapping("/addGreeting")
    public String addGreeting(Greetings greetings){
        
        greetingRepository.save(greetings);
        return "home.html";
    }
}
