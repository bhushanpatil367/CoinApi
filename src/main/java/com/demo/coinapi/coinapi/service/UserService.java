package com.demo.coinapi.coinapi.service;

import com.demo.coinapi.coinapi.dto.UserDto;
import com.demo.coinapi.coinapi.entity.User;

public interface UserService {

	User signUp(User user);
    User login(String username, String password);
    User updateProfile(Long userId, UserDto userDto);
    String getCoinData(Long userId);
}
