package com.demo.coinapi.coinapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.coinapi.coinapi.dto.UserDto;
import com.demo.coinapi.coinapi.entity.User;
import com.demo.coinapi.coinapi.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@Valid @RequestBody User user) {
      User creaeUser = userService.signUp(user);
      return ResponseEntity.ok(creaeUser);
    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @PutMapping("/{userId}")
    public User updateProfile(@PathVariable Long userId, @RequestBody UserDto userDto) {
        return userService.updateProfile(userId, userDto);
    }

    @GetMapping("/{userId}/coins")
    public String getCoinData(@PathVariable Long userId) {
        return userService.getCoinData(userId);
    }
}
