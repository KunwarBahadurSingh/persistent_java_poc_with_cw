package com.persistent.jobportal.repository;

import com.persistent.jobportal.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUsersRepository extends CrudRepository<Users,Long> {

    //verify user based on email and password combination
    Users findByEmailAndPassword(String email, String password);

    //fetch  user based on email
    Users findByEmail(String email);

    //update user based on email
    //UserInfo updateByEmail(UserInfo userInfo);

    //save  user
    Users save(Users users);

    //delete user based on id
    void deleteById(long id);

    //fetch all user
    List<Users> findAll();

}
