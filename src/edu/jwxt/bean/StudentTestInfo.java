package edu.jwxt.bean;

public class StudentTestInfo {

	int sid;
	String name;
	String address;
	String time;
	String kind;
	public StudentTestInfo(int sid, String name, String address, String time, String kind) {
		super();
		this.sid = sid;
		this.name = name;
		this.address = address;
		this.time = time;
		this.kind = kind;
	}
	public StudentTestInfo(String name, String address, String time) {
		super();
		this.name = name;
		this.address = address;
		this.time = time;
	}
	public StudentTestInfo(int sid, String kind) {
		super();
		this.sid = sid;
		this.kind = kind;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
}
