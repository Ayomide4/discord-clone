package com.backend.discord_clone.AppUser;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.discord_clone.Registration.Token.ConfirmationToken;
import com.backend.discord_clone.Registration.Token.ConfirmationTokenService;

import lombok.AllArgsConstructor;


/**
 * AppUser Service class which implements UserDetailsService provides a security from user information.
 */
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService{
    private final static String USER_NOT_FOUND_MSG = "user email %s not found";

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
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
     throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email )));
    }

    /**
     * Signs up New User
     * @param appUser The app user to sign up.
     * @return Returns confirmation when post has been recieved.
     */
    public String signUpUser (AppUser appUser){

        //Statement seeing if user email is already present within the database.
       boolean userExists =  appUserRepository
            .findByEmail(appUser.getEmail()).isPresent();
            //if the user(email) exists, then return it already exists.
            if(userExists) {
                //TODO: Add what to do if user exists
                throw new IllegalStateException("Email Already Taken");
            }

            //Getting user password and encryting it. 
            String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

            //setting user password to the encoded password in the database. 
            appUser.setPassword(encodedPassword);

            //saving new user to database.
            appUserRepository.save(appUser);


            String token = UUID.randomUUID().toString();
            ConfirmationToken confirmationToken = new ConfirmationToken(
                token, 
                LocalDateTime.now(), 
                LocalDateTime.now().plusMinutes(15), 
                appUser);
                
            confirmationTokenService.saveConfirmationToken(confirmationToken);

            //return statement when post is sucessfully recieved.
            return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }


}
