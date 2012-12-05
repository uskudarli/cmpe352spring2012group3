package com.cmpe451.cmpecommunity;

public class Tag {
	private int id;
	private String tag;
	
	public Tag(int id, String tag) {
		this.id = id;
		this.tag = tag;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
}
