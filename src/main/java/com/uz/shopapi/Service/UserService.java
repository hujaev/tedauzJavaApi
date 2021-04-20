package com.uz.shopapi.Service;


import com.uz.shopapi.Model.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<UserDto> getUsers();
    UserDto checkUser(UserDto user);

}
