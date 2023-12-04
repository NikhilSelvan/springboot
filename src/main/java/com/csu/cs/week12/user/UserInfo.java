package com.csu.cs.week12.user;


import jakarta.persistence.*;

@Entity
@Table
public class UserInfo {
    @Id
    @SequenceGenerator(
            name = "User_sequence",
            sequenceName = "User_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "User_sequence"
    )
    private Long id;
    private String name;
    private String phoneNumber;
    private Boolean isServiceProvider;

    public UserInfo() {
    }

    public UserInfo(Long id, String name, String phoneNumber, Boolean isServiceProvider) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isServiceProvider = isServiceProvider;
    }

    public UserInfo(String name, String phoneNumber, Boolean isServiceProvider) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isServiceProvider = isServiceProvider;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getServiceProvider() {
        return isServiceProvider;
    }

    public void setServiceProvider(Boolean serviceProvider) {
        isServiceProvider = serviceProvider;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isServiceProvider=" + isServiceProvider +
                '}';
    }
}
