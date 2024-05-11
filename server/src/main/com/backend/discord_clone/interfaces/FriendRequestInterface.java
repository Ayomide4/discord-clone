package com.backend.discord_clone.Interfaces;

import java.util.List;;

public interface FriendRequestInterface {

    /**
     * Method to get all friend requests
     * @param parentSerial Serial of the user
     * @return List<String> Response model for getting all friend requests
     */
    public List<String> getAllFriendRequests(String parentSerial);

    /**
     * Method to send a friend request
     * @param parentSerial Serial of the user
     * @param friendSerial Serial of the friend
     * @return boolean Response model for sending a friend request
     */
    public boolean sendFriendRequest(String parentSerial, String friendSerial);
    
    /**
     * Method to accept a friend request
     * @param parentSerial Serial of the user
     * @param friendSerial Serial of the friend
     * @return boolean Response model for accepting a friend request
     */
    public boolean acceptFriendRequest(String parentSerial, String friendSerial);
    
    /**
     * Method to decline a friend request
     * @param parentSerial Serial of the user
     * @param friendSerial Serial of the friend
     * @return boolean Response model for declining a friend request
     */
    public boolean declineFriendRequest(String parentSerial, String friendSerial);
    
}
