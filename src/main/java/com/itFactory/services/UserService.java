package com.itFactory.services;

import com.itFactory.dto.UserRequest;
import com.itFactory.dto.UserResponse;
import com.itFactory.model.User;

import java.util.List;

public interface UserService {
    void createUser(UserRequest userRequest);

    UserResponse findUserByEmail(String email);

    int deleteUserById(int id);

    List<UserResponse> findAllUsers();

    void updateEmail(String username, String newEmail);
}
