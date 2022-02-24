package com.ict.demoict.controller;

import java.util.List;

import com.ict.demoict.model.UserContact;
import com.ict.demoict.repo.UserContactRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiict")
public class UserContactController {
    @Autowired
    private UserContactRepo userContactRepo;

    @GetMapping("/usercontact")
    public List<UserContact> getAllEmployees() {
        System.out.println(userContactRepo.findAll());
        return userContactRepo.findAll();
 
    }
}
