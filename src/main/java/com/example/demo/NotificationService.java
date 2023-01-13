package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	@Autowired
	NotificationRepository repo;

	@Autowired
	UserRepository user_repo;

	public void addRecipients(String arr, String msg, String sch, String uame, String ucon) {
		Notification a = new Notification();
		Optional<User> b = user_repo.findUser(uame, ucon);
		a.setValue(msg);
		a.setMultiple_recipient_list(arr);
		a.setNotify_on(sch);
		a.setCreated_by(b.get().getId());
		repo.save(a);
	}
}
