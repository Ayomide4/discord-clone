package com.backend.discord_clone.AppUser;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.discord_clone.Registration.Token.ConfirmationToken;
import com.backend.discord_clone.Registration.Token.ConfirmationTokenService;

import lombok.AllArgsConstructor;


/**
 * AppUserService is the service for the AppUser class.
 */
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService{
    private final static String USER_NOT_FOUND_MSG = "user email %s not found"; //Message for if User is not found.

    @Autowired
    private final AppUserRepository appUserRepository;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private final ConfirmationTokenService confirmationTokenService;
    
    /**
     * Gets User by their email.
     * 
     * @param email User Email.
     * 
     * @return Returns Users information by the Users email.
     */
    @Override
    public UserDetails loadUserByUsername(String email) 
     throws UsernameNotFoundException { //Throws exception if User is not found.
        return appUserRepository.findByEmail(email) //Gets User by email.
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email ))); //Throws exception if User is not found.
    }

    /**
     * Signs up New User
     * @param appUser The app user to sign up.
     * @return Returns confirmation when post has been recieved.
     */
    public String signUpUser (AppUser appUser){

       boolean userExists =  appUserRepository 
            .findByEmail(appUser.getEmail()).isPresent(); //Checks if user exists by email.
            //if the user(email) exists, then return it already exists.
        if(userExists) {
            throw new IllegalStateException("Email Already Taken"); //Throws exception if User already exists.
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword()); //Getting user password and encryting it. 
        appUser.setPassword(encodedPassword); //setting user password to the encoded password in the database. 
        appUserRepository.save(appUser); //saving new user to database.

        String token = UUID.randomUUID().toString(); //generating random token for user.
        ConfirmationToken confirmationToken = new ConfirmationToken( //creating new confirmation token for user.
            token,  //token
            LocalDateTime.now(),  //created at
            LocalDateTime.now().plusMinutes(15),  //expires at
            appUser); //user
            
        confirmationTokenService.saveConfirmationToken(confirmationToken); //saving confirmation token to database.
        return token; //returning token.
    }

    /**
     * Confirms User by token.
     * @param email User Email.
     * @return Returns confirmation when post has been recieved.
     */
    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email); //Confirms User by token.
    }

    // public boolean validUser (String userName) {
    //     boolean userExists =  appUserRepository 
    //         .findByEmail(appUser.getUsername()).isPresent(); //Checks if user exists by email.
    //         //if the user(email) exists, then return it already exists.
    //     if(userExists)
    //         return true;
    //     return false;   
    //     }
}
