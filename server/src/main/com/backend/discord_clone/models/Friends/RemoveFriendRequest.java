package com.backend.discord_clone.models.Friends;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoveFriendRequest {
    private int parentSerial;
    private int friendSerial;
}
