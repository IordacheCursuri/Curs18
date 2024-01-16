package com.itFactory.util;

import com.itFactory.dto.UserRequest;
import com.itFactory.dto.UserResponse;
import com.itFactory.model.User;

public class UserConvertor {

    private UserConvertor(){

    };


    public static User convertFrom(UserRequest userRequest){
        User user = new User();

        user.setId(userRequest.getId());
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setSalary(userRequest.getSalary());

        return user;

    }


    public static UserResponse convertFrom(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setSalary(user.getSalary());

        return userResponse;

    }




}
