package com.backend.discord_clone.models.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserResponse {
    Boolean success;
    String message;
}
