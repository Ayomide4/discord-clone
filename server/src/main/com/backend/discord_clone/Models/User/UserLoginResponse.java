package com.backend.discord_clone.Models.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLoginResponse {
    Boolean success;
    String message;
    String username;
    String sessionToken;
}
