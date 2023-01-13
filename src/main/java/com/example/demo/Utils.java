package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	public String arrToString(ArrayList<String> arr) {
		StringBuffer sb = new StringBuffer();

		for (String s : arr) {
			sb.append(s);
			sb.append(" ");
		}
		String str = sb.toString();

		return str;
	}

	public String createFilename(Notification entry, String contact) {
		String[] date = entry.getNotify_on().split(" ")[0].split("-");
		String con = contact.substring(contact.length() - 4);
		String filename = String.join("_", con, date[2], date[1], date[0]);
		return filename;
	}
}
