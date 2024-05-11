package com.backend.discord_clone.Models.Friends;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetFriendsReponse {
    private boolean success;
    private List<String> friends;
}
