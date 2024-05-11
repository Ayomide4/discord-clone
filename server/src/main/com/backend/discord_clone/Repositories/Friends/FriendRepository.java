package com.backend.discord_clone.Repositories.Friends;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.discord_clone.Models.Friends.Friend;

import jakarta.transaction.Transactional;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer>{

    @Query("SELECT u.username FROM Friend f INNER JOIN User u on u.serial = f.parentSerial WHERE f.parentSerial = ?1")
    List<String> findFriendUserNames(int parentSerial);

    @Transactional
    @Modifying
    @Query("INSERT INTO Friend (parentSerial, friendSerial, dateAdded) VALUES (?1, ?2, CURRENT_DATE)")
    void addFriend(int parentSerial, int friendSerial);

    @Transactional
    @Modifying
    @Query("DELETE FROM Friend WHERE parentSerial = ?1 AND friendSerial = ?2")
    void removeFriend(int parentSerial, int friendSerial);

    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM Friend f WHERE f.parentSerial = ?1 AND f.friendSerial = ?2")
    boolean isFriend(int parentSerial, int friendSerial);

    
    
}
