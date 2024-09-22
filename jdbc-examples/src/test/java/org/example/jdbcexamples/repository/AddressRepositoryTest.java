package org.example.jdbcexamples.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.jdbcexamples.dox.Address;
import org.example.jdbcexamples.dox.User;
import org.example.jdbcexamples.dto.AddressUser;
import org.example.jdbcexamples.dto.AddressUser2;
import org.example.jdbcexamples.dto.UserAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Test
    void findByUserId() {
        for (Address address : addressRepository.findByUserId("1285832708231036928")) {
            log.debug("address: {}", address);
        }
    }
    @Test
    void deleteById(){
        addressRepository.deleteById("4");
    }

    @Test
    void deleteByUserId(){
        addressRepository.deleteByUserId("1256");
        log.debug("Deleted addresses for userId 1256");
    }

    @Test
    void updateDetail(){
        addressRepository.updateDetail("1256","4");
    }

    @Test
    void updateDetailUser(){
        addressRepository.updateDetailUser("1666","1256");
    }

    @Test
    void findAddressUserById() {
        AddressUser addressUser = addressRepository.findAddressUserById("1283819168057049188");
        log.debug(addressUser.toString());
    }

//    @Test
//    void findUserAddress() {
//        User user = userRepository.findById("1057571239761793024").orElse(null);
//        List<Address> addresses = addressRepository.find("1057571239761793024");
//        UserAddress userAddress = UserAddress.builder().user(user).addresses(addresses).build();
//        log.debug(userAddress.toString());
//    }

    @Test
    void findAddressUser2ById() {
        AddressUser2 addressUser2 = addressRepository.findAddressUser2ById("1057590557849407488");
        log.debug("{}", addressUser2.getUser());
        log.debug("{}", addressUser2.getAddress());
    }
}