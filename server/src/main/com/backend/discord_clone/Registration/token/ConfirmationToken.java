package com.backend.discord_clone.Registration.Token;

import java.time.LocalDateTime;
import com.backend.discord_clone.AppUser.AppUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Creates confirmation token for AppUser Authentication. 
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

       //Defining allocation in database
    @SequenceGenerator(
        name = "Confirmation_token_sequence", 
        sequenceName = "Confirmation_token_sequence",
        allocationSize = 1
    )
    @Id
    @GeneratedValue(
        strategy =  GenerationType.SEQUENCE,
        generator = "Confirmation_token_sequence"
    )
    private long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
        nullable = false,
        name = "app_user_id"
    )
    private AppUser appUser;


     /**
      * Creates Email Auth Token.
      * @param createdAt Time the token was created at.
      * @param expiresAt Time the token expires. 
      * @param confirmedAt Time the token was confirmed at.
      * @param appUser The app user.
      */
    public ConfirmationToken(String token, LocalDateTime createdAt, 
    LocalDateTime expiresAt, 
    AppUser appUser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.appUser = appUser;
    }
    
    
}
