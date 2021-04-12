package com.uz.shopapi.service;

import com.uz.shopapi.dto.UserDto;
import com.uz.shopapi.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
    UserDto checkUser(UserDto user);
}
