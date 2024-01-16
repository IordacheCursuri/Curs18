package com.itFactory.controllers;

import com.itFactory.dto.UserRequest;
import com.itFactory.dto.UserResponse;
import com.itFactory.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/v1")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/user")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createUser(@RequestBody UserRequest userRequest) {
//        userService.createUser(userRequest);
//    }

    @PostMapping("/user")
    public ResponseEntity<Void> createUser2(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<UserResponse> findUserByEmail(@RequestParam String email){
        UserResponse userResponse = userService.findUserByEmail(email);

       return ResponseEntity.ok(userResponse);

    //    return new  ResponseEntity<>(userResponse, HttpStatus.OK);
    }

//    @GetMapping("/user")
//    @ResponseStatus(HttpStatus.OK)
//    public UserResponse findUserByEmail2(String email){
//        UserResponse userResponse = userService.findUserByEmail(email);
//        return userResponse;
//
//    }


    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);

    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers(){
        return userService.findAllUsers();
    }

    @PutMapping("/user/{username}/{email}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmail(@PathVariable String username,@PathVariable String email) {
        userService.updateEmail(username, email);
    }


}
