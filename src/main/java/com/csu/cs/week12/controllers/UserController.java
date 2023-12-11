package com.csu.cs.week12.controllers;

import com.csu.cs.week12.models.UserInfo;
import com.csu.cs.week12.models.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserInfo> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void addNewUser(@RequestBody UserInfo userInfo) {
        userService.addNewUser(userInfo);
    }

    @DeleteMapping(path = "{userID}")
    public void deleteUser(@PathVariable("userID") Long userId){
        userService.deleteUser(userId);
    }

}
