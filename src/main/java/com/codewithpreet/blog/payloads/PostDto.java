package com.codewithpreet.blog.payloads;

import com.codewithpreet.blog.entities.Category;
import com.codewithpreet.blog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private String title;
    private String content;
    private String imageName;
    private Date addedDate;

    private Category category;

    private User user;
}
