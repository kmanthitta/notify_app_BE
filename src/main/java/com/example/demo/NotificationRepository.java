package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
	@Query(value = "SELECT * FROM notification WHERE DATE(notify_on)=?1", nativeQuery = true)
	public Optional<List<Notification>> findNotifications(String date);
}
