package com.backend.discord_clone.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginCachedRequest {
    private String sessionToken;
}
