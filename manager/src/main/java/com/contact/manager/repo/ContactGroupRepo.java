package com.contact.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.manager.entities.ContactGroup;

public interface ContactGroupRepo extends JpaRepository<ContactGroup,Integer>{
    
}
