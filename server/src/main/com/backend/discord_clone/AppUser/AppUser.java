package com.backend.discord_clone.AppUser;

 import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
 * Class for the app user implementing UserDetails
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails{

    //Defining allocation in database
    @SequenceGenerator(
        name = "id_sequence", 
        sequenceName = "id_sequence",
        allocationSize = 1

    )
    //defining primary key in DB
    @Id
     //Auto generate ID number
    @GeneratedValue(
        strategy =  GenerationType.SEQUENCE,
        generator = "id_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked = false;
    private Boolean enabled = false;

    

    /**
     * AppUser main Constructor.
     * @param firstName First Name of User.
     * @param lastName Last Name of User.
     * @param userName UserName of user.
     * @param email Email of user.
     * @param password  Password of User. 
     * @param appUserRole General role of User. 
     */
    public AppUser(String firstName, String lastName, String userName, String email, String password, AppUserRole appUserRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
 
    }

    /**
     * Grants authority to User based on role.
     * 
     * @return Returns access from User Roll
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singleton(authority);
    }

    /**
     * Gets and returns Password of the User. 
     * 
     * @return Returns User Password as String. 
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Gets and returns Username of the User.
     * 
     * @return Returns Username as String. 
     */
    @Override
    public String getUsername() {
        return userName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    

    public String getEmail() {
        return email;
    }

    /**
     * Verifys if account is not expired for the User.
     * 
     * @return Returns if User account is not expired as Bool. 
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Verifys if account is not locked from User. 
     * 
     * @return Returns if User account is not locked as Bool. 
     */
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    /**
     * Verifys if credentials is not expired for User.
     * 
     * @return Returns if User credntials are not expired as Bool. 
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    /**
     * verifys if account is active for User. 
     * 
     * @return Returns if User account is enabled as Bool.
     */
    @Override
    public boolean isEnabled() {
        return enabled; 
    }




    
}