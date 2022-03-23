package com.example.JavaAssignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HelloHtmlController { 
//3. task: Has /hello endpoint which returns a HTML page with "Hello World" string displayed.
    
    @RequestMapping("/hello")
    public String helloPage() {
        return "hello.html";
    }
}
