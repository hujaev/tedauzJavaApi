package com.uz.shopapi.Model.LoginModel;


public class UserLoginRequestModel {

    private String username;
    private String userpass;

    public UserLoginRequestModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
}
