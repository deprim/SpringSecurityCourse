package com.example.springcourse.SpringSecurityCourse.services;


import com.example.springcourse.SpringSecurityCourse.model.User;
import com.example.springcourse.SpringSecurityCourse.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> showAllUsers() {
        return usersRepository.findAll();
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        return user;
    }

    public User findUserByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
