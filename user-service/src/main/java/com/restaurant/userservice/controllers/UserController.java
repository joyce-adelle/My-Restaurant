package com.restaurant.userservice.controllers;

import com.restaurant.userservice.model.AddUserDTO;
import com.restaurant.userservice.model.User;
import com.restaurant.userservice.model.ValidateUserDTO;
import com.restaurant.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User addUser(@Validated @RequestBody AddUserDTO user) {
        return userService.addUser(user.getName());
    }

    @PatchMapping("/{id}")
    public User updateUser(@Validated @RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PostMapping("/validate")
    public boolean validateUser(@RequestBody ValidateUserDTO userDTO) {
        return userService.validateUser(userDTO.getId());
    }

}
