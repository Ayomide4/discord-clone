package com.backend.discord_clone.Models.Friends;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddFriendRequest {
    private int parentSerial;
    private int friendSerial;
}
