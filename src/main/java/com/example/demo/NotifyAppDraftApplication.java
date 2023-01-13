package com.example.demo;

import java.io.IOException;

import org.python.jline.internal.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class NotifyAppDraftApplication {

	@Autowired
	PythonScript pyFunc;

	public static void main(String[] args) {
		SpringApplication.run(NotifyAppDraftApplication.class, args);
	}

//	@Scheduled(cron = "0 0 * * *")
	@Scheduled(fixedRate = 1000000L)
	public void testRun() throws IOException {
		Log.info("Printing");
		pyFunc.findNotificationsForToday("2023-01-02");
		Process p = Runtime.getRuntime().exec("python 5155_02_01_2023");
		Log.info("done");
	}
}
