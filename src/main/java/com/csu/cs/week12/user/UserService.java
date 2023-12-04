package com.csu.cs.week12.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<UserInfo> getUsers() {
       return userRepository.findAll();
    }


    public void addNewUser(UserInfo userInfo) {
    }
}
