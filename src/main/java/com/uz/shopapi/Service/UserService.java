package com.uz.shopapi.Service;


import com.uz.shopapi.Model.dto.UserDto;

import java.util.List;


public interface UserService {
    List<UserDto> getUsers();
    UserDto checkUser(UserDto user);

}
