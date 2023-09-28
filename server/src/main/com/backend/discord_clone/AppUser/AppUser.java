package com.backend.discord_clone.AppUser;

 import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * AppUser class is the main class for the User.
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails{

    @SequenceGenerator(     //Generates ID number for User
        name = "id_sequence", //Name of ID number
        sequenceName = "id_sequence", //Name of sequence
        allocationSize = 1 //How many ID numbers to generate
    )
    @Id 

    @GeneratedValue( //Generates ID number for User
        strategy =  GenerationType.SEQUENCE, //Strategy for generating ID number
        generator = "id_sequence" //Name of ID number generator
    )
    private Long id; //ID number for User
    
    private String firstName; //First Name of User
    private String lastName; //Last Name of User
     @Column(name = "UserName", nullable = false)
    private String userName; //Username of User
    @Column(name = "Email", nullable = false)
    private String email; //Email of User
    @Column(name = "Password", nullable = false)
    private String password; //Password of User
    @Enumerated(EnumType.STRING) //Enum for User Role
    private AppUserRole appUserRole; //User Role of User 
    private Boolean locked = false; //Boolean for if User is locked
    private Boolean enabled = false; //Boolean for if User is enabled

    

    /**
     * Constructor for AppUser class.
     * @param firstName First Name of User
     * @param lastName Last Name of User
     * @param userName Username of User
     * @param email Email of User
     * @param password Password of User
     * @param appUserRole User Role of User
     */
    
    public AppUser(String firstName, String lastName, String userName, String email, String password, AppUserRole appUserRole) {
        this.firstName = firstName; //Sets First Name of User
        this.lastName = lastName; //Sets Last Name of User
        this.userName = userName;  //Sets Username of User
        this.email = email; //Sets Email of User
        this.password = password; //Sets Password of User
        this.appUserRole = appUserRole; //Sets User Role of User
 
    }

    /**
     * Grants authority to User based on role.
     * 
     * @return Returns access from User Roll
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //Grants authority to User based on role
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name()); 
        return Collections.singleton(authority); //Returns access from User Roll
    }

    /**
     * Gets and returns Password of the User.
     */
    @Override
    public String getPassword() {
        return password; //Gets and returns Password of the User.
    }


    /**
     * Gets and returns Username of the User.
     * @return Returns Username as String. 
     */
    @Override
    public String getUsername() {
        return userName; //Gets and returns Username of the User.
    }
    /**
     * Gets and returns First Name of the User.
     * @return Returns First Name as String.
     */
    public String getFirstName() {
        return firstName; //Gets and returns First Name of the User.
    }

    /**
     * Gets and returns Last Name of the User.
     * @return Returns Last Name as String.
     */
    public String getLastName() {
        return lastName; //Gets and returns Last Name of the User.
    }
    

    /**
     * Gets and returns Email of the User.
     * @return Returns Email as String.
     */
    public String getEmail() {
        return email; //Gets and returns Email of the User.
    }

    /**
     * Verifys if account is not expired for the User.
     * @return Returns if User account is not expired as Bool. 
     */
    @Override
    public boolean isAccountNonExpired() {
        return true; //Verifys if account is not expired for the User.
    }

    /**
     * Verifys if account is not locked from User. 
     * @return Returns if User account is not locked as Bool. 
     */
    @Override
    public boolean isAccountNonLocked() {
        return !locked; //Verifys if account is not locked from User.
    }

    /**
     * Verifys if credentials is not expired for User.
     * @return Returns if User credntials are not expired as Bool. 
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true; //Verifys if credentials is not expired for User.
    }


    /**
     * Verifys if account is active for User. 
     * @return Returns if User account is enabled as Bool.
     */
    @Override
    public boolean isEnabled() {
        return enabled; //Verifys if account is active for User.
    }






    
}