package com.backend.discord_clone.Repositories;

import java.util.Optional;

import com.backend.discord_clone.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * AppUserRepository is the repository for the AppUser class.
 */
@Transactional(readOnly = true) //Makes all methods in this class read only
public interface AppUserRepository extends JpaRepository<AppUser, Long>{
    Optional<AppUser> findByEmail(String email); //Finds User by email
    Optional<AppUser> findByUserName(String userName); //Finds User by email

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a " +
            "SET a.enabled = TRUE WHERE a.email = ?1") //Query to enable User
    int enableAppUser(String email); //Enables User by email.
}
