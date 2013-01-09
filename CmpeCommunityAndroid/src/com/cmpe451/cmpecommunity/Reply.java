package com.cmpe451.cmpecommunity;

public class Reply {
	private String ownerName;
	private int ownerId;
	private String content;
	private String postingTime;

	public Reply(String ownerName, int ownerId, String content, String postingTime) {
		this.ownerName = ownerName;
		this.ownerId = ownerId;
		this.postingTime = postingTime;
		this.content = content;
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
