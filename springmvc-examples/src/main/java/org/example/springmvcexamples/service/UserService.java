package org.example.springmvcexamples.service;

import org.example.springmvcexamples.dox.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> USERS = create();
    private static List<User> create(){
        User u = User.builder()
                .id(1)
                .name("Z")
                .role(User.ADMIN)
                .password("$2a$10$XPz7Kp1kF8NU3vewqqPGn.feT7UPvhoZolvJ1JRi57s16XKMWz9OW")
                .account("zet")
                .build();
        User u2 = User.builder()
                .id(2)
                .name("Wrrr")
                .role(User.USER)
                .password("$2a$10$XPz7Kp1kF8NU3vewqqPGn.feT7UPvhoZolvJ1JRi57s16XKMWz9OW")
                .account("wle")
                .build();
        return List.of(u,u2);
    }
    public List<User> listUsers() {
        return USERS;
    }
//
//    public User getUserByAccount(String account,String password) {
//        return USERS.stream()
//                .filter(u -> u.getAccount().equals(account))
//                .filter(u -> u.getPassword().equals(password))
//                .findFirst()
//                .orElse(null);
//    }
    public User getUserByAccount(String account) {
        return USERS.stream()
                .filter(u -> u.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }
}
