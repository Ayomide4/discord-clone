package com.backend.discord_clone.AppUser;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provides User data by their email.
 */

 @Configuration
@Repository
@Transactional(readOnly = true)
public interface AppUserRepository {
    Optional<AppUser> findByEmail(String email);
}
