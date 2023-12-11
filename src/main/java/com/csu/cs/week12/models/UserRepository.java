package com.csu.cs.week12.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<UserInfo, Long> {

    @Query("SELECT s FROM UserInfo s WHERE s.id =?1")
    UserInfo findUserInfoById(Long id);

    @Query("SELECT s FROM UserInfo s WHERE s.phoneNumber =?1")
    UserInfo findUserInfoByPhoneNumber(String phoneNumber);

    @Query("SELECT s FROM UserInfo s WHERE s.phoneNumber =?1 and s.password = ?2")
    UserInfo findUserInfoByPhoneNumberAndPassword(String phoneNumber, String password);
}
