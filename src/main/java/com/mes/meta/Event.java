package com.mes.meta;

import java.util.Date;

public class Event {
	private String id;
	private String name;
	private String location;
	private String starttime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", location=" + location + ", starttime=" + starttime + "]";
	}

}
