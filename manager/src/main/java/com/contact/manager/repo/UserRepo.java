package com.contact.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.contact.manager.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>
{

    int countByUsername(String username);

}
