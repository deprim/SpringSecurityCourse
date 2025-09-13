package com.example.springcourse.SpringSecurityCourse.services;

import com.example.springcourse.SpringSecurityCourse.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.springcourse.SpringSecurityCourse.principal.UserPrincipal;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public MyUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userService.findUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User not found");
        return new UserPrincipal(user);
    }
}
