package org.example.jdbcexamples.repository;

import org.example.jdbcexamples.dox.Address;
import org.example.jdbcexamples.dto.AddressUser;
import org.example.jdbcexamples.dto.AddressUser2;
import org.example.jdbcexamples.mapper.AddressUser2RowMapper;
import org.example.jdbcexamples.mapper.AdressUserRowMapper;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

//    @Query("""
//            select * from address a
//            where a.user_id = :userId
//            """)
    List<Address> findByUserId(String userId);

    @Modifying
    @Query("""
            delete from address a where a.user_id = :userId
            """)
    void deleteByUserId(String userId);

    @Modifying
    @Query("""
            update address a set a.detail=:detail where a.id=:id
            """)
    void updateDetail(String detail, String id);

    @Modifying
    @Query("""
            update address a set a.detail=:detail where a.user_id=:id
            """)
    void updateDetailUser(String detail, String id);

    @Query(value = "select * from address a,user u where a.user_id=u.id and a.id=:aid",
    rowMapperClass = AdressUserRowMapper.class)
    AddressUser findAddressUserById(String aid);

    @Query(value = "select * from address a join user u on u.id = a.user_id where a.id=:aid",
            rowMapperClass = AddressUser2RowMapper.class)
    AddressUser2 findAddressUser2ById(String aid);

}
