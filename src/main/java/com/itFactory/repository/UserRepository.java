package com.itFactory.repository;

import com.itFactory.model.User;

import java.util.List;

public interface UserRepository {


    void createUser(User user);

    User findUserByEmail(String email);

    int deleteUserById(int id);

    List<User> getAllUsers();

    int updateEmail(String username, String newEmail);
}
