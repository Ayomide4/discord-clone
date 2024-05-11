package com.backend.discord_clone.Interfaces;

import com.backend.discord_clone.Models.Friends.AddFriendRequest;
import com.backend.discord_clone.Models.Friends.AddFriendResponse;
import com.backend.discord_clone.Models.Friends.GetFriendRequest;
import com.backend.discord_clone.Models.Friends.GetFriendsReponse;
import com.backend.discord_clone.Models.Friends.RemoveFriendRequest;
import com.backend.discord_clone.Models.Friends.RemoveFriendResponse;

public interface FriendInterface {

    /**
     * Method to add a friend
     * @param parentSerial Serial of the user
     * @param friendSerial Serial of the friend
     * @return boolean Response model for adding a friend
     */
    public AddFriendResponse addFriend(AddFriendRequest addFriendRequest);

    /**
     * Method to remove a friend
     * @param parentSerial Serial of the user
     * @param friendSerial Serial of the friend
     * @return boolean Response model for removing a friend
     */
    public RemoveFriendResponse removeFriend(RemoveFriendRequest removeFriendRequest);

    /**
     * Method to get all friends
     * @param parentSerial Serial of the user
     * @return List<String> Response model for getting all friends
     */
    public GetFriendsReponse getAllFriends(GetFriendRequest getFriendsRequest);
}
