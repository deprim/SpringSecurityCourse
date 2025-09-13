package com.example.springcourse.SpringSecurityCourse.controller;

import com.example.springcourse.SpringSecurityCourse.model.Users;
import com.example.springcourse.SpringSecurityCourse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UsersContoller {


    private final UserService userService;

    @Autowired
    public UsersContoller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> showAllUsers(){

        return userService.showAllUsers();

    }



}
