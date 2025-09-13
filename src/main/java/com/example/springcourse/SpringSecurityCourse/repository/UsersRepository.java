package com.example.springcourse.SpringSecurityCourse.repository;

import com.example.springcourse.SpringSecurityCourse.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
