package com.example.springcourse.SpringSecurityCourse.controller;

import com.example.springcourse.SpringSecurityCourse.model.User;
import com.example.springcourse.SpringSecurityCourse.security.MyUserDetails;
import com.example.springcourse.SpringSecurityCourse.services.UserService;
import com.example.springcourse.SpringSecurityCourse.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UsersController {

    private final UserValidator userValidator;
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService,
                           UserValidator userValidator) {

        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/hello")
    public String hello() {
        userService.test();
        return "/hello";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {

        return "/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") User user,
                                      BindingResult result) {

//        userValidator.validate(user, result);
//        if (result.hasErrors()) {
//            System.out.println(result.getAllErrors());
//            return "/registration";
//        } else {
        System.out.println(">>> performRegistration called with: " + user);

        userService.registerUser(user);
            return "redirect:/login";
//        }



    }

    @GetMapping("/admin")
    public String adminPage(){
        return "/admin";
    }


//    @GetMapping("/showUserInfo")
//    public String showUserInfo(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        MyUserDetails userPrincipal;
//
//        // Проверяем, что объект не null и является экземпляром UserPrincipal
//        if (authentication != null && authentication.getPrincipal() instanceof MyUserDetails) {
//            userPrincipal = (MyUserDetails) authentication.getPrincipal();
//            System.out.println(userPrincipal.getUser());
//        } else {
//            // Пользователь не аутентифицирован или анонимен
//            System.out.println("Пользователь не найден или анонимен.");
//            // Можно перенаправить на страницу логина
//            return "redirect:/login";
//        }
//
//        return "hello";
    }

//    @GetMapping("/users")
//    public List<User> showAllUsers(){
//
//        return userService.showAllUsers();
//
//    }





