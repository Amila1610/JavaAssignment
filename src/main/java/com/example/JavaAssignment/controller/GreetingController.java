package com.example.JavaAssignment.controller;

import com.example.JavaAssignment.models.Greetings;
import com.example.JavaAssignment.service.GreetingRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
//@RequestMapping("/greetings")
public class GreetingController {
    
   @Autowired
    GreetingRepository greetingRepository;
   
  @GetMapping(path="/getGreetings")
    private List<Greetings> getAllGreetings(){
        return (List<Greetings>) greetingRepository.findAll();
    }
           
    /* @GetMapping("/greetings/{id}")
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
    
    @RequestMapping(value="/addGreeting", method=RequestMethod.POST)
    public String addGreeting(@RequestParam("greeting")String greeting, @RequestParam("language") String language){
        Greetings greetings=new Greetings();
        greetings.setGreeting(greeting);
        greetings.setLanguage(language);
        greetingRepository.save(greetings);
        return "Saved!";
    }
    
}
