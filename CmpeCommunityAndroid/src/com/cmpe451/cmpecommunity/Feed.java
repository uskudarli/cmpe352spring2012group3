package com.cmpe451.cmpecommunity;

public class Feed {
	private int id;
	private String ownerName;
	private int ownerId;
	private String content;
	private String postingTime;

	public Feed(int id, String ownerName, int ownerId, String content, String postingTime) {
		this.id = id;
		this.ownerName = ownerName;
		this.ownerId = ownerId;
		this.postingTime = postingTime;
		this.content = content;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPostingTime() {
		return postingTime;
	}
	public void setPostingTime(String postingTime) {
		this.postingTime = postingTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
