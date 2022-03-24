package com.example.JavaAssignment.controller;

import com.example.JavaAssignment.models.Greetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloRestController {
    
    @Autowired
    private GreetingController greetingController;
    
    @GetMapping("/hello-rest") //Second task: Has /hello-rest REST endpoint which returns 'HelloWorld' string.
    public String HelloRest(){
        return "Hello World";
    }
    
   @GetMapping("/hello")
   public String helloPage(@RequestParam(value="lang") String language){
       Greetings greetings=greetingController.getGreetingByLang(language);
       return "Helo World on" + greetings.getLanguage()+ "language is:" + greetings.getGreeting();
   }
}
