package com.backend.discord_clone.Models.Friends;

import java.sql.Date;

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

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "\"FRIEND\"")
public class Friend {

    @SequenceGenerator(name = "id_sequence", sequenceName = "id_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @Column(name = "\"SERIAL\"")
    private int serial; 
    @Column(name = "\"PARENT_SERIAL\"")
    private int parentSerial;
    @Column(name = "\"FRIEND_SERIAL\"")
    private int friendSerial;
    @Column(name = "\"DATE_ADDED\"")
    private Date dateAdded;
}
