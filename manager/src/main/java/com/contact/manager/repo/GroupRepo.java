package com.contact.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.manager.entities.Group;

public interface GroupRepo extends JpaRepository<Group,Integer>
{
    
}
