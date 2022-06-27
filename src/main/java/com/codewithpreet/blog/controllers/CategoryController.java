package com.codewithpreet.blog.controllers;

import com.codewithpreet.blog.payloads.ApiResponse;
import com.codewithpreet.blog.payloads.CategoryDto;
import com.codewithpreet.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> crateCategory(@Valid @RequestBody CategoryDto categoryDto)
    {
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }
    //Update
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer catId)
    {
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,catId);
        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }
    //Delete
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId)
    {
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted",true), HttpStatus.CREATED);
    }
    //Get
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId)
    {
        CategoryDto categoryDto=this.categoryService.getCategory(catId);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }
    //Get All
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories()
    {
       List<CategoryDto> categories=this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }
}
