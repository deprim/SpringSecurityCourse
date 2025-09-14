package com.example.springcourse.SpringSecurityCourse.controller;

import com.example.springcourse.SpringSecurityCourse.model.User;
import com.example.springcourse.SpringSecurityCourse.security.MyUserDetails;
import com.example.springcourse.SpringSecurityCourse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UsersController {


    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/showUserInfo")
    public String showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails userPrincipal;

        // Проверяем, что объект не null и является экземпляром UserPrincipal
        if (authentication != null && authentication.getPrincipal() instanceof MyUserDetails) {
            userPrincipal = (MyUserDetails) authentication.getPrincipal();
            System.out.println(userPrincipal.getUser());
        } else {
            // Пользователь не аутентифицирован или анонимен
            System.out.println("Пользователь не найден или анонимен.");
            // Можно перенаправить на страницу логина
            return "redirect:/login";
        }

        return "hello";
    }

    @GetMapping("/users")
    public List<User> showAllUsers(){

        return userService.showAllUsers();

    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user){
        return userService.registerUser(user);
    }



}
