package com.example.springcourse.SpringSecurityCourse.services;

import com.example.springcourse.SpringSecurityCourse.model.Users;
import com.example.springcourse.SpringSecurityCourse.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> showAllUsers() {
        return usersRepository.findAll();
    }

    public Users findUserByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
