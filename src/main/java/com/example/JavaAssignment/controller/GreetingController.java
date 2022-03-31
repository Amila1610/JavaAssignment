package com.example.JavaAssignment.controller;

import com.example.JavaAssignment.models.Greetings;
import com.example.JavaAssignment.service.GreetingService;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    
    @Autowired
    private GreetingService greetingService;  
   
  @GetMapping(path="/getGreetings")
    private List<Greetings> getAllGreetings(){
        return greetingService.getAllGreetings();
    }
           
    /* @GetMapping("/greetings/{id}")
    public Optional<Greetings> getGreetingById(@PathVariable("id")Integer id){
        return greetingRepository.findById(id);
    }
    */
    public Greetings getGreetingByLang(String lang){
        List<Greetings> greetings= greetingService.getAllGreetings();
        for(Greetings greeting:greetings)
            if(greeting.getLanguage().equalsIgnoreCase(lang))
                return greeting;
        return null;
    }
    
    @RequestMapping(value="/addGreeting", method=RequestMethod.POST)
    public String addGreeting(@RequestParam("greeting")String greeting, @RequestParam("language") String language){
        Greetings greetings=new Greetings();
        greetings.setGreeting(greeting);
        greetings.setLanguage(language);
        greetingService.saveOrUpdate(greetings);
        return "Saved!";
    }
    
}
