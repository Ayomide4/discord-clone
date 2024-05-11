package com.backend.discord_clone.models.Friends;

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
