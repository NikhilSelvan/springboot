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



    private String password;

    public UserInfo() {
    }

    public UserInfo(Long id, String name, String phoneNumber, Boolean isServiceProvider, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isServiceProvider = isServiceProvider;
        this.password = password;
    }

    public UserInfo(String name, String phoneNumber, Boolean isServiceProvider, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isServiceProvider = isServiceProvider;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
