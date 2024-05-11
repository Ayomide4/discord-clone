package com.backend.discord_clone.Repositories;

import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.discord_clone.Models.User.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findBySessionToken(String sessionToken);
    Optional<User> findBySerial(int serial);

    @Transactional
    @Modifying
    @Query("UPDATE User u " +
            "SET u.enabled = TRUE WHERE u.email = ?1")
    int enableUser(String email);

    @Transactional
    @Modifying
    @Query("Update User u "
            + "SET u.lastSignIn = LOCALTIMESTAMP Where u.email = ?1")
    void updateLastSignIn(String email);

    @Transactional
    @Modifying
    @Query("Update User u "
            + "SET u.sessionToken = ?2 Where u.email = ?1")
    void updateSessionToken(String email, String sessionToken);

}
