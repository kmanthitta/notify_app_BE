package com.example.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PythonScript {
	@Autowired
	NotificationRepository notRepo;

	@Autowired
	Utils utils;

	public void findNotificationsForToday(String date) throws IOException {
		Optional<List<Notification>> list = notRepo.findNotifications(date);
		if (list.isPresent()) {
			list.get().forEach(item -> {
				String[] recList = item.getMultiple_recipient_list().split(" ");
				String[] time = item.getNotify_on().split(" ")[1].split(":");
				for (String n : recList) {
					String filename = utils.createFilename(item, n);
					try {
						PrintWriter pw = new PrintWriter(new FileWriter("scripts/" + filename));
						pw.println("import pywhatkit as pw");
//						pw.printf("pw.sendwhatmsg(\"%s\",\"%s\",%d,%d)", n, item.getValue(), Integer.parseInt(time[0]),
//								Integer.parseInt(time[1]));
						pw.printf("pw.sendwhatmsg(\"%s\",\"%s\",%d,%d)", "+919819645155", "Heyy", 21, 32);
						pw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

		}
	}
}
