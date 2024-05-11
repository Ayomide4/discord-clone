package com.backend.discord_clone.Repositories.Friends;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.discord_clone.Models.Friends.FriendRequest;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Integer>{
    
}
