package com.example.FureverFriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.FureverFriends.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	@Query(value="select * from roles where role=:role",nativeQuery = true)
	Role findByRole(String role);

}
