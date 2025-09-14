package com.example.springcourse.SpringSecurityCourse.services;

import com.example.springcourse.SpringSecurityCourse.model.User;
import com.example.springcourse.SpringSecurityCourse.repository.UsersRepository;
import com.example.springcourse.SpringSecurityCourse.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public MyUserDetailService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User not found");
        return new MyUserDetails(user);
    }
}
