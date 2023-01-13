package com.example.demo;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository repo;

	public void addUser(Map<String, Object> payload) {
		String uname = (String) payload.get("sender_name");
		String ucon = (String) payload.get("sender_contact");
		User a = new User();
		a.setName(uname);
		a.setContact(ucon);
		Optional<User> b = repo.findUser(uname, ucon);
		if (b.isEmpty()) {
			repo.save(a);
		}
	}
}
