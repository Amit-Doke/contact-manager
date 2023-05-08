package com.contact.manager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.manager.entities.Contact;
import com.contact.manager.entities.ContactGroup;
import com.contact.manager.entities.User;
import com.contact.manager.repo.ContactGroupRepo;
import com.contact.manager.repo.ContactRepo;
import com.contact.manager.repo.UserRepo;


import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("contacts")
public class ContactController 
{
    @Autowired
    UserRepo userRepo;

    @Autowired
    ContactRepo contactRepo;

    @Autowired
    ContactGroupRepo contactGroupRepo;
    

    @GetMapping("getContacts/{userId}")
    public List<Contact> getContacts(@PathVariable Integer userId)
    {
        try 
        {
            List<Contact> contacts = userRepo.findById(userId).get().getContacts();
            log.info("Getting Contact List of User with UserId => {}", userId);
            return contacts;
        } 
        catch (Exception e) 
        {
            log.error(e.getMessage(), e);
            return null;
        }
    } 

    @PostMapping("createContact/{userId}/{groupId}")
    public boolean createContact(@RequestBody Contact contact,@PathVariable Integer userId,@PathVariable Integer groupId)
    {
        log.info(contact+"\n"+userId+"\n"+groupId);
        try 
        {
            if (contact.getEmail()!=null && contact.getPhoneNumber()!=null && contact.getName()!=null) {
                User user = userRepo.findById(userId).get();
                ContactGroup contactGroup = contactGroupRepo.findById(groupId).get();
                contact.setContactGroup(contactGroup);
                user.getContacts().add(contact);
                userRepo.save(user);
                log.info("User Contact successfully created for User Id => "+user.getId());
                return true;
            }
            return false;
        }
        catch (Exception e) 
        {
            log.error(e.getMessage(), e);
            return false;            
        }
    }


    @PutMapping("updateContact/{userId}/{groupId}")
    public boolean updateContact(@RequestBody Contact contact,@PathVariable Integer userId,@PathVariable Integer groupId)
    {
        log.info(contact+"\n"+userId+"\n"+groupId);
        try 
        {
            if (contact.getEmail()!=null && contact.getPhoneNumber()!=null && contact.getName()!=null) {
                Contact dbContact=contactRepo.save(contact);
                log.info("User Contact successfully created for User Id => "+dbContact);
                return true;
            }
            return false;
        }
        catch (Exception e) 
        {
            log.error(e.getMessage(), e);
            return false;            
        }
    }


    @DeleteMapping("{userId}/{contactId}")
    public Boolean deleteContact(@PathVariable Integer userId,@PathVariable Integer contactId)
    {
        try 
        {
            boolean flag=false;
            User user=userRepo.findById(userId).get();
            flag=user.getContacts().removeIf(temp-> temp.getId()==contactId);
            userRepo.save(user);
            contactRepo.deleteById(contactId);
            log.info("Getting Contact List of Contact with contactId => {}", flag);
            return flag;
        } 
        catch (Exception e) 
        {
            log.error(e.getMessage(), e);
            return null;
        }
    } 





    @GetMapping("getContact/{contactId}")
    public Contact getContact(@PathVariable Integer contactId)
    {
        try 
        {
            Contact contact = contactRepo.findById(contactId).get();
            log.info("Getting Contact List of Contact with contactId => {}", contact);
            return contact;
        } 
        catch (Exception e) 
        {
            log.error(e.getMessage(), e);
            return null;
        }
    } 

    

    @GetMapping("getGroup")
    public List<ContactGroup> getGroup()
    {
        try 
        {
            List<ContactGroup> groups =  contactGroupRepo.findAll();
            log.info("Getting Contact List of Contact with contactId => {}", groups);
            return groups;
        } 
        catch (Exception e) 
        {
            log.error(e.getMessage(), e);
            return null;
        }
    }

}
