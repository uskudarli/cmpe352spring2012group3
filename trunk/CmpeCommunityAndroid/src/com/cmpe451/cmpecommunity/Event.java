package com.cmpe451.cmpecommunity;

public class Event {
	private int id;
	private String place;
	private String description;
	private String time;
	private String ownerName;
	private int ownerId;

	public Event(int id, String place, String description, String time,
			String ownerName, int ownerId) {
		super();
		this.id = id;
		this.place = place;
		this.description = description;
		this.time = time;
		this.ownerName = ownerName;
		this.ownerId = ownerId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

}
