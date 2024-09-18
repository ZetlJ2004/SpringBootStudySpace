package org.example.jdbcexamples.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.jdbcexamples.dox.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;
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
}