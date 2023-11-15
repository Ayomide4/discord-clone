package com.backend.discord_clone.AppUser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


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
    public void signUpUser (AppUser appUser){

       boolean userExists =  appUserRepository 
            .findByEmail(appUser.getEmail()).isPresent(); //Checks if user exists by email.
            //if the user(email) exists, then return it already exists.
        if(userExists) {
            throw new IllegalStateException("Email Already Taken"); //Throws exception if User already exists.
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword()); //Getting user password and encryting it. 
        appUser.setPassword(encodedPassword); //setting user password to the encoded password in the database. 
        appUserRepository.save(appUser); //saving new user to database.
    }

 
}
