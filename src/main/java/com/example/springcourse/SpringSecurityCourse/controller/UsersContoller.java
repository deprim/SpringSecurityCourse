package com.example.springcourse.SpringSecurityCourse.controller;

import com.example.springcourse.SpringSecurityCourse.model.Users;
import com.example.springcourse.SpringSecurityCourse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UsersContoller {


    private final UserService userService;

    @Autowired
    public UsersContoller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> showAllUsers(){

        return userService.showAllUsers();

    }

    @PostMapping("/register")
    public Users createUser(@RequestBody Users user){
        return userService.registerUser(user);
    }



}
