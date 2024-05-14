package com.backend.discord_clone.Services.Friends;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.discord_clone.Repositories.UserRepository;
import com.backend.discord_clone.Repositories.Friends.FriendRepository;
import com.backend.discord_clone.Interfaces.FriendInterface;
import com.backend.discord_clone.Models.Friends.AddFriendRequest;
import com.backend.discord_clone.Models.Friends.AddFriendResponse;
import com.backend.discord_clone.Models.Friends.GetFriendRequest;
import com.backend.discord_clone.Models.Friends.GetFriendsReponse;
import com.backend.discord_clone.Models.Friends.RemoveFriendRequest;
import com.backend.discord_clone.Models.Friends.RemoveFriendResponse;

@Service
public class FriendService implements FriendInterface{

    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(FriendService.class);


    @Override
    public AddFriendResponse addFriend(AddFriendRequest addFriendRequest) {
        try{
            if(!userRepository.findBySerial(addFriendRequest.getFriendSerial()).isPresent()){
                return new AddFriendResponse(false, "User does not exist");
            }
            if(friendRepository.isFriend(addFriendRequest.getParentSerial(), addFriendRequest.getFriendSerial())){
                return new AddFriendResponse(false, "User is already a friend");
            }
            friendRepository.addFriend(addFriendRequest.getParentSerial(), addFriendRequest.getFriendSerial());
        }
        catch(Exception e){
            logger.error(addFriendRequest.getParentSerial() + " friend could not add " + addFriendRequest.getFriendSerial()+ " : " + e.getMessage());
            return new AddFriendResponse(false, "Error adding friend");
        }
        return new AddFriendResponse(true, "Friend added");
    }

    @Override
    public RemoveFriendResponse removeFriend(RemoveFriendRequest removeFriendRequest) {
        try{
            if(friendRepository.isFriend(removeFriendRequest.getParentSerial(), removeFriendRequest.getFriendSerial())){
                friendRepository.removeFriend(removeFriendRequest.getParentSerial(), removeFriendRequest.getFriendSerial());
                return new RemoveFriendResponse(true, "Friend removed");
            }
        }
        catch(Exception e){
            logger.error(removeFriendRequest.getFriendSerial() + " friend could not remove " + removeFriendRequest.getFriendSerial() + " : " + e.getMessage());
            return new RemoveFriendResponse(false, "Error removing friend");
        }
        return new RemoveFriendResponse(false, "User is not a friend");
    }

    @Override
    public GetFriendsReponse getAllFriends(GetFriendRequest getFriendsRequest) {
        try{
            return new GetFriendsReponse(true, friendRepository.findFriendUserNames(getFriendsRequest.getParentSerial()));
        }
        catch(Exception e){
            logger.error(getFriendsRequest.getParentSerial() + " error retrieving friends: " + e.getMessage());
            return new GetFriendsReponse(false, null);
        }
    }
}
