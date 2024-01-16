package com.itFactory.services;

import com.itFactory.dto.UserRequest;
import com.itFactory.dto.UserResponse;
import com.itFactory.errors.UserWasNotDeletedException;
import com.itFactory.errors.UserWasNotUpdatedException;
import com.itFactory.model.User;
import com.itFactory.repository.UserRepository;
import com.itFactory.util.UserConvertor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void createUser(UserRequest userRequest){
        //todo:
        // 1. Vreau sa ne asiguram ca in baza noastra de date exista useri cu email unic;
        // 2. Cauta i  baza de date daca exista acel user cu acel email;
        // 3. Daca userul exista vreau sa arunc o eroare: -> UserAlreadyExistsException cu HttpStatus 400(BadRequest)
        // 4. Daca userul cu acel mail nu exista vreu sa salvez userul in baza de date.

        User user = UserConvertor.convertFrom(userRequest);

        userRepository.createUser(user);
    }

    @Override
    public UserResponse findUserByEmail(String email) {

        User user = userRepository.findUserByEmail(email);

        logger.info("User with email: {} was found", email);
        UserResponse userResponse = null;

        if(user != null) {
            userResponse = UserConvertor.convertFrom(user);
        }

        return userResponse;

    }

    @Override
    public int deleteUserById(int id) {
        int isDeleted = userRepository.deleteUserById(id);

        if(isDeleted > 0) {
            logger.info("User with id {} was deleted", id);
            return 1;
        }

        throw new UserWasNotDeletedException("User with Id: " + id + " was not deleted");

    }

    @Override
    public List<UserResponse> findAllUsers() {
        List<User> users = userRepository.getAllUsers();

        List<UserResponse> userResponses = new ArrayList<>();


        for (User user: users){
            UserResponse userResponse = UserConvertor.convertFrom(user);
            userResponses.add(userResponse);
        }

        return userResponses;
    }

    @Override
    public void updateEmail(String username, String newEmail) {

        int isUpdated = userRepository.updateEmail(username, newEmail);

        if(isUpdated > 0) {
            logger.debug("User with username: {} updated his email with email: {}", username, newEmail);
            return;
        }

        throw new UserWasNotUpdatedException("Email of username: " + username + " was not updated");


    }








}
