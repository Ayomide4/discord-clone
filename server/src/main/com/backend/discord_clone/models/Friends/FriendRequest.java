package com.backend.discord_clone.models.Friends;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "\"FRIEND_REQUEST\"")
public class FriendRequest {
    @SequenceGenerator(name = "id_sequence", sequenceName = "id_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @Column(name = "\"SERIAL\"")
    private int serial;
    @Column(name = "\"PARENT_SERIAL\"")
    private int parentSerial;
    @Column(name = "\"REQUESTING_SERIAL\"")
    private int requestingSerial;
    @Column(name = "\"ACTIVE\"")
    private boolean active;
}
