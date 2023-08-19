package com.backend.discord_clone.Registration;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.discord_clone.AppUser.AppUser;
import com.backend.discord_clone.AppUser.AppUserRole;
import com.backend.discord_clone.AppUser.AppUserService;
import com.backend.discord_clone.Registration.Token.ConfirmationToken;
import com.backend.discord_clone.Registration.Token.ConfirmationTokenService;

import lombok.AllArgsConstructor;

/**
 * RegistrationService provides the service of registering new Users.
 */
@Service
@AllArgsConstructor
public class RegistrationService {

private final AppUserService appUserService;
private final EmailValidation emailValidation;
    private final ConfirmationTokenService confirmationTokenService;



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

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }

}
