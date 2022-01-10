package com.enterprise.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.inventory.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{
	User findByFirstName(String firstName);
}
