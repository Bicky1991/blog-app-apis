package com.codewithpreet.blog.services;

import com.codewithpreet.blog.payloads.CategoryDto;

import java.util.List;


public interface CategoryService {

    //Create
    CategoryDto createCategory(CategoryDto categoryDto);
    //Update
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
    //Delete
    void deleteCategory (Integer categoryId);
    //Get Single
    CategoryDto getCategory(Integer categoryId);
    //Get All
    List<CategoryDto> getCategories();
}
