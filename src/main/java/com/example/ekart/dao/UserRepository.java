package com.example.ekart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ekart.model.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
	 UserInfo findByUsername(String username);

}
