package com.codewithpreet.blog.payloads;

import com.codewithpreet.blog.entities.Category;
import com.codewithpreet.blog.entities.User;

import java.util.Date;

public class PostDto {

    private String title;
    private String content;
    private String imageName;
    private Date addedDate;

    private Category category;

    private User user;
}
