package com.backend.discord_clone.Models.User;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "\"USER\"")
public class User implements UserDetails {

    @SequenceGenerator(name = "id_sequence", sequenceName = "id_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @Column(name = "\"SERIAL\"")
    private int serial;

    @Column(name = "\"USERNAME\"")
    private String username;
    @Column(name = "\"PASSWORD\"")
    private String password;
    @Column(name = "\"EMAIL\"")
    private String email;
    @Column(name = "\"ROLE\"")
    private UserRole role;
    @Column(name = "\"DISPLAY_NAME\"")
    private String displayName;
    @Column(name = "\"DOB\"")
    private Date dob;
    @Column(name = "\"LOCKED\"")
    private Boolean locked = false;
    @Column(name = "\"ENABLED\"")
    private Boolean enabled = true;
    @Column(name = "\"LAST_SIGN_IN\"")
    private LocalDateTime lastSignIn;
    @Column(name = "\"SESSION_TOKEN\"")
    private String sessionToken;

    public User(String username, String password, String email, String displayName,
    Date dob, UserRole role, String sessionToken) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.displayName = displayName;
        this.dob = dob;
        if (role == null)
            this.role = UserRole.USER;
        else
            this.role = role;
        this.sessionToken = sessionToken;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
