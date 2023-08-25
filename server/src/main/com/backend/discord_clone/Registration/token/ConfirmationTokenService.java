package com.backend.discord_clone.Registration.Token;

    import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
    import lombok.AllArgsConstructor;

/**
 * Creates confirmation token key for AppUser.
 */
@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }
    
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
    
}

