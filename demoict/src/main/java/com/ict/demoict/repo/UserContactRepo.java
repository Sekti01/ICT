package com.ict.demoict.repo;

import com.ict.demoict.model.UserContact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContactRepo extends JpaRepository<UserContact,String>{
    
}