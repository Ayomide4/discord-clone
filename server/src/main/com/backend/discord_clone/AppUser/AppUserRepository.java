package com.backend.discord_clone.AppUser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provides User data by their email.
 */
@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long>{
    Optional<AppUser> findByEmail(String email);
}
