package com.backend.discord_clone.Registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;


/**
 * EmailValidation is the class for email validation.
 */
@Service
public class EmailValidation implements Predicate<String>{

    /**
     * Tests email.
     */
    @Override
    public boolean test(String t) {
        return true; //Returns true.
    }
    
}
