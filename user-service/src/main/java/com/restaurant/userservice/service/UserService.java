package com.restaurant.userservice.service;

import com.restaurant.userservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private final List<User> users;

    public UserService() {

        this.users = new ArrayList<>(Arrays.asList(User.builder()
                        .id(10L)
                        .name("User 1")
                        .active(true)
                        .build(),
                User.builder()
                        .id(20L)
                        .name("User 2")
                        .active(true)
                        .build(),
                User.builder()
                        .id(30L)
                        .name("User 3")
                        .active(false)
                        .build()));

    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(long id) {

        Optional<User> userOp = users.stream().filter(user -> user.getId() == id).findFirst();
        return userOp.orElse(null);

    }

    public User updateUser(User user) {

        Optional<User> userOp = users.stream()
                .filter(userF -> userF.getId() == user.getId())
                .map(user1 -> {
                    user1.setActive(user.isActive());
                    user1.setName(user.getName());
                    return user1;
                })
                .findFirst();
        return userOp.orElse(null);

    }

    public User addUser(String name) {

        User newUser = User.builder()
                .id((users.size() + 1) * 10L)
                .name(name)
                .active(true)
                .build();
        users.add(newUser);

        return newUser;

    }

    public boolean deleteUser(long id) {

        Optional<User> userOp = users.stream()
                .filter(userF -> userF.getId() == id)
                .map(user1 -> {
                    user1.setActive(false);
                    return user1;
                })
                .findFirst();

        return userOp.isPresent();

    }

    public boolean validateUser(long id) {

        Optional<User> userOp = users.stream().filter(user -> user.getId() == id).findFirst();
        return userOp.map(User::isActive).orElse(false);

    }

}
