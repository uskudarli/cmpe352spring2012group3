package Tables;

import com.sun.jmx.snmp.Timestamp;

public class EventTable {
	private int id;
	private int userId;
	private String description;
	private String place;
	private java.sql.Timestamp eventTime;
	public EventTable(int id, int userId, String description, String place,
			java.sql.Timestamp eventTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.description = description;
		this.place = place;
		this.eventTime = eventTime;
	}
	public EventTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public java.sql.Timestamp getEventTime() {
		return eventTime;
	}
	public void setEventTime(java.sql.Timestamp eventTime) {
		this.eventTime = eventTime;
	}
	
	
}
