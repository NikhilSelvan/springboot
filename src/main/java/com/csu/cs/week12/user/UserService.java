package com.csu.cs.week12.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<UserInfo> userByPhoneNumber = userRepository
                .findUserInfoByPhoneNumber(userInfo.getPhoneNumber());
        if (userByPhoneNumber.isPresent()){
            throw new IllegalStateException("phone already used");
        }
        userRepository.save(userInfo);
        System.out.println("new user has been inserted successfully");
    }

    public void deleteUser(Long userId) {
               boolean exists = userRepository.existsById(userId);
                if (!exists) {
                    throw new IllegalStateException("user with id" + userId + " does not exist");
                }
                userRepository.deleteById(userId);
    }
}