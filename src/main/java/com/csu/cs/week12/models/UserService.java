package com.csu.cs.week12.models;

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
        UserInfo userByPhoneNumber = userRepository
                .findUserInfoByPhoneNumber(userInfo.getPhoneNumber());
        if (userByPhoneNumber != null){
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

    public UserInfo findUserInfoByPhoneNumber(String phoneNumber) {
        UserInfo userInfo = userRepository.findUserInfoByPhoneNumber(phoneNumber);
        if (userInfo == null) {
            System.out.println("No user found");
            return null;
        } else {
            System.out.println("User already exists");
            return userInfo;
        }

    }

    public UserInfo findUserInfoById(Long userId) {
        UserInfo userInfo = userRepository.findUserInfoById(userId);
        if (userInfo == null) {
            System.out.println("No user found");
            return null;
        } else {
            System.out.println("User already exists");
            return userInfo;
        }

    }

    public UserInfo findUserInfoByPhoneNumberAndPassword(String phoneNumber, String password){
        UserInfo userInfo = userRepository.findUserInfoByPhoneNumberAndPassword(phoneNumber, password);
        if (userInfo == null) {
            System.out.println("No user found");
            return null;
        } else {
            System.out.println("User already exists");
            return userInfo;
        }
    }

    public void saveUser(UserInfo userInfo) {
        userRepository.save(userInfo);
    }
}