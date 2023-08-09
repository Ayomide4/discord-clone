package com.backend.discord_clone.AppUser;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


/**
 * AppUser Service class which implements UserDetailsService provides a security from user information.
 */
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService{
    private final static String USER_NOT_FOUND_MSG = "user email %s not found";
    private final AppUserRepository appUserRepository;

    /**
     * Gets User by their email.
     * 
     * @param email User Email.
     * 
     * @return Returns Users information by the Users email.
     */
    @Override
    public UserDetails loadUserByUsername(String email)
     throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email )));
    }
    
}
