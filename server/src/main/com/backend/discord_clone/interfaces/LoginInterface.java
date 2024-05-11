package com.backend.discord_clone.interfaces;

import com.backend.discord_clone.models.User.CachedLoginResponse;
import com.backend.discord_clone.models.User.CreateUserRequest;
import com.backend.discord_clone.models.User.CreateUserResponse;
import com.backend.discord_clone.models.User.UserLoginReponse;
import com.backend.discord_clone.models.User.UserLoginRequest;
import com.backend.discord_clone.models.User.UserLoginCachedRequest;

public interface LoginInterface {
    
    /**
     * Method to login a user
     * @param userLoginRequest Request model for login
     * @return UserLoginReponse Response model for login
     */
    public UserLoginReponse login(UserLoginRequest userLoginRequest);

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
