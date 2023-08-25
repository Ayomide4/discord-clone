package com.backend.discord_clone.Registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;


@Service
public class EmailValidation implements Predicate<String>{

    @Override
    public boolean test(String t) {
        return true;
    }
    
}
