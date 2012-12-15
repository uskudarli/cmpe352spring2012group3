package com.cmpe451.cmpecommunity;

public class User {
	private int id;
	private String name;
	private String imageURL;
	
	public User(int id, String name, String imageURL) {
		super();
		this.id = id;
		this.name = name;
		this.imageURL = imageURL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
}
