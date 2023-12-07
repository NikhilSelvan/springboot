package com.csu.cs.week12.controllers;

import com.csu.cs.week12.user.UserInfo;
import com.csu.cs.week12.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

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
