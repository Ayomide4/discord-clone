package com.backend.discord_clone.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


/**
 * AppUser Service class which implements UserDetailsService provides a security from user information.
 */
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService{
    private final static String USER_NOT_FOUND_MSG = "user email %s not found";

    @Autowired
    private final AppUserRepository appUserRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

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

    /**
     * Signs up New User
     * @param appUser The app user to sign up.
     * @return
     */
    public String signUpUser (AppUser appUser){

        //Statement seeing if user email is already present within the database.
       boolean userExists =  appUserRepository
            .findByEmail(appUser.getEmail()).isPresent();

            //if the user(email) exists, then return it already exists.
            if(userExists) {
                //TODO
                //TODO

                throw new IllegalStateException("Email Already Taken");
            }

            //Getting user password and encryting it. 
            String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

            //setting user password to the encoded password in the database. 
            appUser.setPassword(encodedPassword);

            //saving new user to database.
            appUserRepository.save(appUser);

            //TODO:Send conformation Token


            return "Registration Post Recieved";
    }
    
}
