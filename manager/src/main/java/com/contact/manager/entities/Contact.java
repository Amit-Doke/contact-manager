package com.contact.manager.entities;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data@Entity
public class Contact 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    String name;
    String email;
    String url;
    String phoneNumber;
    String company;
    String title;
    @OneToOne(cascade = CascadeType.ALL)
    ContactGroup contactGroup;



}
