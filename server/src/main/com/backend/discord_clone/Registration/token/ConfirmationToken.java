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

    @SequenceGenerator(    //Generates ID number for User
        name = "Confirmation_token_sequence",  //Name of ID number
        sequenceName = "Confirmation_token_sequence", //Name of sequence
        allocationSize = 1 //How many ID numbers to generate
    )
    
    @Id
    @GeneratedValue( //Generates ID number for User
        strategy =  GenerationType.SEQUENCE, //Strategy for generating ID number
        generator = "Confirmation_token_sequence" //Name of ID number generator
    )
    private long id; //Column for ID

    @Column(nullable = false) //Column for token
    private String token;

    @Column(nullable = false) //Column for created at
    private LocalDateTime createdAt;
    
    @Column(nullable = false) //Column for expires at
    private LocalDateTime expiresAt;
    
    private LocalDateTime confirmedAt; //Column for confirmed at

    @ManyToOne
    @JoinColumn( //Joins App User to Confirmation Token
        nullable = false,
        name = "app_user_id"
    )
    private AppUser appUser; //App User


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
        this.token = token; //Token
        this.createdAt = createdAt; //Created At
        this.expiresAt = expiresAt; //Expires At
        this.appUser = appUser; //App User
    }
    
    
}
