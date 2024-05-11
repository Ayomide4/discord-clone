package com.backend.discord_clone.Models.User;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String displayName;
    private String username;
    private String email;
    private String password;
    private Date dob;
}
