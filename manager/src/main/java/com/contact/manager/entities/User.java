package com.contact.manager.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String username;
    String password;
    String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    Set<Contact> contacts;

}
