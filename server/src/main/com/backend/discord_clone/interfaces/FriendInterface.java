package com.backend.discord_clone.interfaces;

import com.backend.discord_clone.models.Friends.AddFriendRequest;
import com.backend.discord_clone.models.Friends.AddFriendResponse;
import com.backend.discord_clone.models.Friends.GetFriendsReponse;
import com.backend.discord_clone.models.Friends.GetFriendRequest;
import com.backend.discord_clone.models.Friends.RemoveFriendRequest;
import com.backend.discord_clone.models.Friends.RemoveFriendResponse;

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
