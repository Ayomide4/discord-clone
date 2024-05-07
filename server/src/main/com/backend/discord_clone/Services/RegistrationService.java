package com.backend.discord_clone.Services;

import com.backend.discord_clone.Model.AppUser;
import com.backend.discord_clone.Model.AppUserRole;
import com.backend.discord_clone.Model.RegistrationRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

/**
 * RegistrationService provides the service of registering new Users.
 */
@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;

    /**
     * Validates that post Request has been recived.
     * 
     * @param request The Post Request Information.
     * @return Returns Post Request confirmation.
     */
    public String register(RegistrationRequest request) {
         String registerSucessful = "Registration Successful.";
        try {
            appUserService.signUpUser( // Signs up new User.
                    new AppUser( // Creates new AppUser.
                            request.getFirstName(), // Gets first name.
                            request.getLastName(), // Gets last name.
                            request.getUserName(), // Gets username.
                            request.getEmail(), // Gets email.
                            request.getPassword(), // Gets password.
                            AppUserRole.USER // Sets role to user.
                    ));
            return registerSucessful;
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Could not register.");
        }
    }

}
