package com.persistent.jobportal.controller;

import com.persistent.jobportal.entity.Users;
import com.persistent.jobportal.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/user")
public class UsersController {
    @Autowired
    private UsersServiceImpl usersServiceImpl;

    //register user
    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users userInfo) {
        Users user = usersServiceImpl.registerUser(userInfo);
        return new ResponseEntity<Users>(user, HttpStatus.CREATED);
    }

    //get all users
    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = usersServiceImpl.getAllUsers();
        return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
    }

    //verify user
    @PostMapping("/verifyLogin")
    public ResponseEntity<Users> verifyUser(@RequestBody Users users) {
        Users user = null;
        user = usersServiceImpl.verifyUser(users.getEmail(), users.getPassword());
        if(null == user) {
            return null;
        } else {
            return new ResponseEntity<Users>(users, HttpStatus.OK);
        }
    }
}
