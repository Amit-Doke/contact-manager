package com.contact.manager.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.manager.repo.GroupRepo;
import com.contact.manager.repo.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@Slf4j
public class ContactController 
{
    UserRepo userRepo;
    
    GroupRepo groupRepo;

    @GetMapping("getContacts")
    public List<>
}
