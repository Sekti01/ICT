package com.ict.demoict.controller;

import java.util.List;
import java.util.Optional;

import com.ict.demoict.model.Users;
import com.ict.demoict.repo.UserRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiict")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public List<Users> getAllEmployees() {
        System.out.println(userRepo.findAll());
        return userRepo.findAll();
 
    }

    @GetMapping("/users/{id}")
	public Optional<Users> find(@PathVariable("id") String id){
		return userRepo.findById(id);
	}

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> delete(
            @PathVariable("id") String id) {
        try {
            userRepo.deleteById(id);
            System.out.print("Deleted");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Users> create(
            @RequestBody Users users) {
        try {
            Users newUsers = new Users();
            newUsers.setId(users.getId());
            newUsers.setName(users.getName());
            newUsers.setAge(users.getAge());
            return new ResponseEntity<>(userRepo.save(newUsers), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
