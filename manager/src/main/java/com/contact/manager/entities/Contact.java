package com.contact.manager.entities;



import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data@RequiredArgsConstructor@Entity
public class Contact 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer uId;
    
    String name;
    String email;
    String password;
    String url;
    String phoneNumber;
    String company;
    String title;
    @OneToMany
    Set<Group> groups;



}
