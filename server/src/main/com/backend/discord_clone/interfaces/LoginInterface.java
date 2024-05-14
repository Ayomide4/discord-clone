package com.backend.discord_clone.Interfaces;

import com.backend.discord_clone.Models.User.CachedLoginResponse;
import com.backend.discord_clone.Models.User.CreateUserRequest;
import com.backend.discord_clone.Models.User.CreateUserResponse;
import com.backend.discord_clone.Models.User.UserLoginCachedRequest;
import com.backend.discord_clone.Models.User.UserLoginResponse;
import com.backend.discord_clone.Models.User.UserLoginRequest;

public interface LoginInterface {
    
    /**
     * Method to login a user
     * @param userLoginRequest Request model for login
     * @return UserLoginReponse Response model for login
     */
    public UserLoginResponse login(UserLoginRequest userLoginRequest);

    /**
     * Method to create a user
     * @param user User model for creating a user
     * @return CreateUserResponse Response model for creating a user
     */
    public CreateUserResponse createUser(CreateUserRequest createUserRequest);

    /**
     * Method to login a cached user
     * @param userLoginCachedRequest Request model for login
     * @return CachedLoginResponse Response model for login
     */
    public CachedLoginResponse loginCachedUser(UserLoginCachedRequest userLoginCachedRequest);

}
