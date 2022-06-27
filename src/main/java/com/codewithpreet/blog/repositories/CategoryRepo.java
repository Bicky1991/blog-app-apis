package com.codewithpreet.blog.repositories;

import com.codewithpreet.blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
