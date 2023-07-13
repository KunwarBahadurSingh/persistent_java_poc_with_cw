package com.persistent.jobportal.service.impl;

import com.persistent.jobportal.entity.Users;
import com.persistent.jobportal.repository.IUsersRepository;
import com.persistent.jobportal.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements IUsersService {
    @Autowired
    private IUsersRepository iUserInfoRepository;

    // verify user based on email and password
    @Override
    public Users verifyUser(String email, String password) {
        Users user = iUserInfoRepository.findByEmailAndPassword(email, password);
        return user;
    }

    // register user
    @Override
    public Users registerUser(Users users) {
        return iUserInfoRepository.save(users);
    }

    //get all users
    @Override
    public List<Users> getAllUsers() {
        return iUserInfoRepository.findAll();
    }

}
