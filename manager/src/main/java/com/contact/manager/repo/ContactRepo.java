package com.contact.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.manager.entities.Contact;

public interface ContactRepo extends JpaRepository<Contact,Integer> {
    
}
