package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT * FROM user WHERE name=?1 AND contact=?2", nativeQuery = true)
	public Optional<User> findUser(String name, String contact);
}
