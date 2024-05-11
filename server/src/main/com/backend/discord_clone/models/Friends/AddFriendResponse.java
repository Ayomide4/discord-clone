package com.backend.discord_clone.Models.Friends;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AddFriendResponse {
    private boolean success;
    private String message;    
}
