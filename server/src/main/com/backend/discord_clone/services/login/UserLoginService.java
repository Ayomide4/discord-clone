package com.backend.discord_clone.Services.Login;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.discord_clone.Interfaces.LoginInterface;
import com.backend.discord_clone.Repositories.UserRepository;
import com.backend.discord_clone.Models.User.CachedLoginResponse;
import com.backend.discord_clone.Models.User.CreateUserRequest;
import com.backend.discord_clone.Models.User.CreateUserResponse;
import com.backend.discord_clone.Models.User.User;
import com.backend.discord_clone.Models.User.UserLoginCachedRequest;
import com.backend.discord_clone.Models.User.UserLoginResponse;
import com.backend.discord_clone.Models.User.UserLoginRequest;
import com.backend.discord_clone.Models.User.UserRole;


@Service
public class UserLoginService implements LoginInterface {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    Logger logger = LoggerFactory.getLogger(UserLoginService.class);

    @Override
    /**
     * Method to login a user
     * 
     * @param userLoginRequest Request model for login
     */
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        try {
            Optional<User> user = userRepository.findByEmail(userLoginRequest.getEmail());
            String sessionToken = java.util.UUID.randomUUID().toString();

            if (userRepository.findByEmail(userLoginRequest.getEmail()).isPresent()) {
                if (bCryptPasswordEncoder.matches(userLoginRequest.getPassword(), user.get().getPassword())) {
                    userRepository.updateLastSignIn(userLoginRequest.getEmail());
                    userRepository.updateSessionToken(userLoginRequest.getEmail(), sessionToken);

                    logger.info(userLoginRequest.getEmail() + " logged in " + LocalDateTime.now());
                    return new UserLoginResponse(true, "Login successful", user.get().getUsername(),  sessionToken);
                } else {
                    logger.info(userLoginRequest.getEmail() + " incorrect password " + LocalDateTime.now());
                    return new UserLoginResponse(false, "Incorrect password", null,  null);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.info(userLoginRequest.getEmail() + " not found " + LocalDateTime.now());
        return new UserLoginResponse(false, "Email not found", null, null);
    }

    @Override
    /**
     * Method to create a user
     * 
     * @param user User model for creating a user
     */
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        if (createUserRequest.getUsername().isEmpty() || createUserRequest.getPassword().isEmpty()
                || createUserRequest.getEmail().isEmpty() || createUserRequest.getDisplayName().isEmpty() || createUserRequest.getDob().toString().isEmpty())
            return new CreateUserResponse(false, "Missing fields");

        if (userRepository.findByUsername(createUserRequest.getUsername()).isPresent()) {
            logger.info(createUserRequest.getUsername() + " already exists " + LocalDateTime.now());
            return new CreateUserResponse(false, "Username already exists");
        }

        if (userRepository.findByEmail(createUserRequest.getEmail()).isPresent()) {
            logger.info(createUserRequest.getEmail() + " already exists " + LocalDateTime.now());
            return new CreateUserResponse(false, "Email already exists");
        }

        if (LocalDateTime.now().getYear() - createUserRequest.getDob().toLocalDate().getYear() < 12) {
            logger.info(createUserRequest.getUsername() + " is too young " + LocalDateTime.now());
            return new CreateUserResponse(false, "User is too young to create an account");
        }

        createUserRequest.setPassword(bCryptPasswordEncoder.encode(createUserRequest.getPassword()));
        try {
            userRepository.save(new User(
                    createUserRequest.getUsername(),
                    createUserRequest.getPassword(),
                    createUserRequest.getEmail(),
                    createUserRequest.getDisplayName(),
                    createUserRequest.getDob(),
                    UserRole.USER,
                    null));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new CreateUserResponse(false, "Error creating user");
        }
        logger.info(createUserRequest.getUsername() + " created account " + LocalDateTime.now());
        return new CreateUserResponse(true, "User created");
    }

    @Override
    /**
     * Method to login a cached user
     * 
     * @param userLoginCachedRequest Request model for login
     */
    public CachedLoginResponse loginCachedUser(UserLoginCachedRequest userLoginCachedRequest) {
        try {
            Optional<User> user = userRepository.findBySessionToken(userLoginCachedRequest.getSessionToken());

            if (userRepository.findBySessionToken(userLoginCachedRequest.getSessionToken()).isPresent()) {
                userRepository.updateLastSignIn(user.get().getUsername());
                logger.info(user.get().getUsername() + " logged in " + LocalDateTime.now());
                return new CachedLoginResponse(true, "Login successful");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return new CachedLoginResponse(false, "Token not found");
    }

}
