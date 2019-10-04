package com.mentor.common;

import java.util.List;

import com.mentor.entity.User;

public interface UserService {

    User create(User user);

    User delete(int id);

    List<User> findAll();

    User findById(int id);
    
    User findUser(String userName,String password);

    User update(User user);
}
