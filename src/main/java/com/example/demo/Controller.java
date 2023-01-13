package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	UserRepository repo;
	@Autowired
	UserService service;
	@Autowired
	NotificationService notservice;
	@Autowired
	Utils utils;
	@Autowired
	NotificationRepository notrepo;

	@RequestMapping("/")
	@ResponseBody
	@CrossOrigin
	public Optional<User> home(@RequestParam String name, @RequestParam String contact) {
		return repo.findUser(name, contact);
	}

	@PostMapping("/test")
	@CrossOrigin
	public void test(@RequestBody Map<String, Object> payload) {
		service.addUser(payload);
		ArrayList<String> arr = (ArrayList<String>) payload.get("recipients");
		String uname = (String) payload.get("sender_name");
		String ucon = (String) payload.get("sender_contact");
		String rec = utils.arrToString(arr);
		String msg = (String) payload.get("message");
		String sch = (String) payload.get("schedule");
		notservice.addRecipients(rec, msg, sch, uname, ucon);
	}

	@GetMapping("/get")
	public void getDate(@RequestParam String date) {
		System.out.println(LocalDate.now());
		String a = LocalDate.now().toString();
		Optional<List<Notification>> notif = notrepo.findNotifications(date);
	}
}
