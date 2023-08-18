package com.backend.discord_clone.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.discord_clone.AppUser.AppUser;
import com.backend.discord_clone.AppUser.AppUserRole;
import com.backend.discord_clone.AppUser.AppUserService;

import lombok.AllArgsConstructor;

/**
 * RegistrationService provides the service of registering new Users.
 */
@Service
@AllArgsConstructor
public class RegistrationService {

@Autowired
private final AppUserService appUserService;
@Autowired
private final EmailValidation emailValidation;


/**
 * Validates that post Request has been recived.
 * @param request The Post Request Information.
 * @return Returns Post Request confirmation.
 */
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidation.test(request.getEmail());

        //if email is already in use:
        if (!isValidEmail){
            throw new IllegalStateException("Email not valid");
        }

        //return the user information to the database. 
        return appUserService.signUpUser( 
            new AppUser(
            request.getFirstName(),
            request.getLastName(),
            request.getUserName(),
            request.getEmail(),
            request.getPassword(),
            AppUserRole.USER
        )
            );
    }

}
