package com.example.JavaAssignment.service;

import com.example.JavaAssignment.models.Greetings;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    
    @Autowired
    private GreetingRepository greetingRepository;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public List<Greetings> getAllGreetings(){
        List<Greetings> greetings= new ArrayList<Greetings>();
        greetingRepository.findAll().forEach(greetings1->greetings.add(greetings1));
        return greetings;
    }
    
    public Greetings getGreetingsById(int id) {
        return greetingRepository.findById(id).get();
    }
    
    public void saveOrUpdate(Greetings greetings) {
        greetingRepository.save(greetings);
    }

    public void delete(int id) {
        greetingRepository.deleteById(id);
    }
}