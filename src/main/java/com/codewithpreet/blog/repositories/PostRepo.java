package com.codewithpreet.blog.repositories;

import com.codewithpreet.blog.entities.Category;
import com.codewithpreet.blog.entities.Post;
import com.codewithpreet.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
