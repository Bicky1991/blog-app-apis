package com.codewithpreet.blog.controllers;

import com.codewithpreet.blog.payloads.ApiResponse;
import com.codewithpreet.blog.payloads.UserDto;
import com.codewithpreet.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    //POST-create here
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
    {
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }
    //PUT-update user
    @PutMapping("/{userId}")
    public  ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId")Integer uid)
    {
        UserDto updatedUser = this.userService.updateUser(userDto,uid);
        return ResponseEntity.ok(updatedUser);
    }
    //DELETE-delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity <ApiResponse> deleteUser(@PathVariable("userId") Integer uid)
    {
        this.userService.deleteUser(uid);
        return new ResponseEntity(new ApiResponse("User Deleted Succesfully",true), HttpStatus.OK);
    }
    //GET-all user get
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
    //GET-single user get
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId)
    {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
