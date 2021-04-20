package com.uz.shopapi.Model.LoginModel;


public class UserLoginRequestModel {

    private String login;
    private String password;

    public UserLoginRequestModel() {
    }

    public String getEmail() {
        return login;
    }

    public void setEmail(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
