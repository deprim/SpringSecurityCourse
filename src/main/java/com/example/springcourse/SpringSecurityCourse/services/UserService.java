package com.example.springcourse.SpringSecurityCourse.services;


import com.example.springcourse.SpringSecurityCourse.model.User;
import com.example.springcourse.SpringSecurityCourse.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


//    public List<User> showAllUsers() {
//        return usersRepository.findAll();
//    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void test(){
        System.out.println("Hello epta");
    }


    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        usersRepository.save(user);
    }

    public User findUserByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
