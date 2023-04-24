package com.contact.manager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Group 
{
    @Id
    Integer id;
    String groupName;
}
