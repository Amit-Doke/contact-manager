package com.contact.manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.manager.entities.User;
import com.contact.manager.repo.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("users")
public class UserController {
    
    @Autowired
    UserRepo userRepo;

    @PostMapping("create")
    public boolean create(@RequestBody User user)
    {
        try {
            if (user.getUsername()!=null && user.getPassword()!=null) {
                if (userRepo.countByUsername(user.getUsername())==0) {
                    userRepo.save(user);
                    log.info("User saved successfully => ", user);
                    return true;
                }
                log.error("User with this userrname already present in database ",user);
            }
            log.error("User don't have username or password ",user);
            return false;
        } 
        catch (Exception e) {
            log.error("User creation failed due to exception ",e);
            return false;
        }
    }


    @GetMapping("getUser/{userId}")
    public User getUserById(@PathVariable Integer userId)
    {
        try {
                User user =userRepo.findById(userId).get();
                log.info("User with id "+userId+" found in database");     
                return user;
        } 
        catch (Exception e) {
            e.printStackTrace();
            log.error("User with id "+userId+" can't be found in database",e);
            return null;
        }
    }

    
}
