package com.codewithpreet.blog.security;

import com.codewithpreet.blog.entities.User;
import com.codewithpreet.blog.exceptions.ResourceNotFoundException;
import com.codewithpreet.blog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Loading User From By UserName
        User user = this.userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User", "email : " + username, 0));

        return user;
    }
}
