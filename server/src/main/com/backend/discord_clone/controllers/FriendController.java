package com.backend.discord_clone.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backend.discord_clone.models.Friends.GetFriendsReponse;
import com.backend.discord_clone.models.Friends.RemoveFriendRequest;
import com.backend.discord_clone.models.Friends.RemoveFriendResponse;
import com.backend.discord_clone.Interfaces.FriendInterface;
import com.backend.discord_clone.Models.Friends.RemoveFriendRequest;
import com.backend.discord_clone.Models.Friends.RemoveFriendResponse;
import com.backend.discord_clone.interfaces.FriendInterface;;
import com.backend.discord_clone.models.Friends.GetFriendRequest;

@Controller
@RequestMapping("/api/v1")
public class FriendController {

    private final FriendInterface friendService;

    public FriendController(@Autowired FriendService friendService) {
        this.friendService = friendService;
    }

    @PostMapping("/getFriends")
    public ResponseEntity<GetFriendsReponse> getFriends(@RequestBody GetFriendRequest getFriendRequest) {
        return new ResponseEntity<>(friendService.getAllFriends(getFriendRequest), HttpStatus.OK);
    }

    @PostMapping("/addFriend")
    public ResponseEntity<AddFriendResponse> addFriend(@RequestBody AddFriendRequest addFriendRequest) {
        return new ResponseEntity<>(friendService.addFriend(addFriendRequest), HttpStatus.OK);
    }

    @PostMapping("/removeFriend")
    public ResponseEntity<RemoveFriendResponse> removeFriend(@RequestBody RemoveFriendRequest removeFriendRequest) {
        return new ResponseEntity<>(friendService.removeFriend(removeFriendRequest), HttpStatus.OK);
    }
}
