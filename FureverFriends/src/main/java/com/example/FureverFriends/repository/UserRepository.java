package com.example.FureverFriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FureverFriends.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);

    //@Query(value="select * from the users where username=:username",nativeQuery=true)
    Users findByUsername( String username);
}