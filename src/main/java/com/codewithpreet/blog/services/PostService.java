package com.codewithpreet.blog.services;

import com.codewithpreet.blog.entities.Post;
import com.codewithpreet.blog.payloads.PostDto;

import java.util.List;

public interface PostService {

    //Create
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //Update
    Post updatePost(PostDto postDto,Integer postId);

    //Delete
    void deletePost(Integer postId);

    //Get all posts
    List<Post> getAllPost();

    //Get single post
    Post getPostId(Integer postId);

    //Get all post by category
    List<Post> getPostByCategory(Integer categoryId);

    //Get all posts by user
    List<Post> getPostByUser(Integer userId);

    //Search posts
    List<Post> searchPost(String keyword);
}
