package com.backend.discord_clone.Registration.token;

import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

import com.backend.discord_clone.AppUser.AppUser;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConfirmationToken {

       //Defining allocation in database
    @SequenceGenerator(
        name = "Confirmation_token_sequence", 
        sequenceName = "Confirmation_token_sequence",
        allocationSize = 1

    )
    //defining primary key in DB
    @Id
     //Auto generate ID number
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
      */
    public ConfirmationToken(LocalDateTime createdAt, 
    LocalDateTime expiresAt, 
    LocalDateTime confirmedAt,
    AppUser appUser) {
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.confirmedAt = confirmedAt;
        this.appUser = appUser;
    }
    
    
}
