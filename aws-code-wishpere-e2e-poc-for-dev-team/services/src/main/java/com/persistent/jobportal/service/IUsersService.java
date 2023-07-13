package com.persistent.jobportal.service;

import com.persistent.jobportal.entity.Users;

import java.util.List;

public interface IUsersService {
    //verify user based on email and password
    public Users verifyUser(String email, String password);

    //register user
    public Users registerUser(Users users);

    //get all users
    public List<Users> getAllUsers();
}
