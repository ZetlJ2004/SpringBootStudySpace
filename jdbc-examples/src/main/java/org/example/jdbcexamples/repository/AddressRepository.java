package org.example.jdbcexamples.repository;

import org.example.jdbcexamples.dox.Address;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

    @Query("""
            select * from address a 
            where a.user_id = :userId
            """)
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
}
