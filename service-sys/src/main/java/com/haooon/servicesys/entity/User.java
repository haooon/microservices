package com.haooon.servicesys.entity;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer userStatus;

    private Integer userWrongSign;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserWrongSign() {
        return userWrongSign;
    }

    public void setUserWrongSign(Integer userWrongSign) {
        this.userWrongSign = userWrongSign;
    }
}