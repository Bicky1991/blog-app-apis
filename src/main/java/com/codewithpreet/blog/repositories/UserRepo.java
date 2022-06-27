package com.codewithpreet.blog.repositories;

import com.codewithpreet.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User,Integer>{
}
