package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Notification {
	@Id
	public int id;
	public String value;
	public String multiple_recipient_list;
	public String notify_on;
	public int created_by;

	public String getNotify_on() {
		return notify_on;
	}

	public void setNotify_on(String notify_on) {
		this.notify_on = notify_on;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public String getMultiple_recipient_list() {
		return multiple_recipient_list;
	}

	public void setMultiple_recipient_list(String multiple_recipient_list) {
		this.multiple_recipient_list = multiple_recipient_list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
