package com.example.JavaAssignment.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloRestController {
    
    @GetMapping("/hello-rest") //Second task: Has /hello-rest REST endpoint which returns 'HelloWorld' string.
    public String HelloRest(){
        return "Hello World";
    }
    
}
