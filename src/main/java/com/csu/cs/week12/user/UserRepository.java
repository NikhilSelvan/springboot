package com.csu.cs.week12.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<UserInfo, Long> {


    @Query("SELECT s FROM UserInfo s WHERE s.phoneNumber =?1")
    Optional<UserInfo> findUserInfoByPhoneNumber(String phoneNumber);
}
