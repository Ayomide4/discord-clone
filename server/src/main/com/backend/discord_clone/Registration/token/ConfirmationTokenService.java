package com.backend.discord_clone.Registration.Token;

    import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

/**
 * Creates confirmation token key for AppUser.
 */
@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    @Autowired
    private final ConfirmationTokenRepository confirmationTokenRepository;

    /**
     * Saves confirmation token to database.
     * @param token The token to save.
     */
    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token); //Saves token to database.
    }
    
    /**
     * Gets token by token.
     * @param token The token to get.
     * @return Returns token by token.
     */
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token); //Gets token by token.
    }

    /**
     * Sets confirmed at.
     */
    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt( 
                token, LocalDateTime.now());  //Sets confirmed at.
    }
    
}

