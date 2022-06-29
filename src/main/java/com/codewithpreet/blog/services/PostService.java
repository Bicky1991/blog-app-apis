package com.codewithpreet.blog.services;

import com.codewithpreet.blog.entities.Post;
import com.codewithpreet.blog.payloads.PostDto;
import com.codewithpreet.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {

    //Create
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //Update
    PostDto updatePost(PostDto postDto,Integer postId);

    //Delete
    void deletePost(Integer postId);

    //Get all posts
    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);

    //Get single post
    PostDto getPostById(Integer postId);

    //Get all post by category
    List<PostDto> getPostsByCategory(Integer categoryId);

    //Get all posts by user
    List<PostDto> getPostsByUser(Integer userId);

    //Search posts
    List<Post> searchPost(String keyword);

}
