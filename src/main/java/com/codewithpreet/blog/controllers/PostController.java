package com.codewithpreet.blog.controllers;

import com.codewithpreet.blog.entities.Post;
import com.codewithpreet.blog.payloads.ApiResponse;
import com.codewithpreet.blog.payloads.PostDto;
import com.codewithpreet.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    //Create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                              @PathVariable Integer userId,
                                              @PathVariable Integer categoryId )
    {
        PostDto createPost=this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }
   //Get By User
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId)
    {
        List<PostDto> posts=this.postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }
    //Get By Category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId)
    {
        List<PostDto> posts=this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }
    //Get All Posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost()
    {
        List<PostDto> allPost=this.postService.getAllPost();
        return new ResponseEntity<List<PostDto>>(allPost,HttpStatus.OK);
    }
    //Get Post Details By id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
    {
        PostDto postDto=this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
    }
    //Delete Post
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId)
    {
        this.postService.deletePost(postId);
        return new ApiResponse("Post is successfully Deleted !!",true);
    }
    //Update Posts
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId)
    {
        PostDto updatePost=this.postService.updatePost(postDto,postId);
        return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
    }
}
