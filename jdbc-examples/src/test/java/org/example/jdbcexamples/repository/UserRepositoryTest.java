package org.example.jdbcexamples.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.jdbcexamples.dox.Address;
import org.example.jdbcexamples.dox.User;
import org.example.jdbcexamples.dto.AddressUser;
import org.example.jdbcexamples.dto.UserAddress;
import org.example.jdbcexamples.dto.UserAddress3;
import org.example.jdbcexamples.dto.UserCountDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {
        var user = User.builder()
                .name("sss")
                .build();
        userRepository.save(user);
    }

    @Test
    public void findById() {
        userRepository.findById("1530375756270878723")
                .ifPresent(user -> log.debug("{}", user));
    }

    @Test
    void findAll() {
        int pageSize = 5;
        int page = 4;
        userRepository.findAll((page - 1) * pageSize, 5)
                .forEach(user -> log.debug(user.toString()));
    }

    @Test
    void findAllPageable() {
        int pageSize = 5;
        int page = 4;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        userRepository.findAll((java.awt.print.Pageable) pageable)
                .forEach(user -> log.debug(user.toString()));
    }

    @Test
    void findByIdDesc() {
        int pageSize = 5;
        int page = 1;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        userRepository.findByIdDesc((java.awt.print.Pageable) pageable)
                .forEach(user -> log.debug(user.toString()));
    }

    @Test
    void testFindUserAddress() {
        UserAddress addreddUser = userRepository.findUserAddress("1285832708231036928");
        for (Address address : addreddUser.getAddresses()) {
            log.debug("{}", address.toString());
        }
    }

    @Test
    void testFindUserAddress3() {
    }

    @Test
    void findCounts() {
        for(UserCountDTO count : userRepository.findCounts()){
            log.debug("{}", count.toString());
        }
    }
}