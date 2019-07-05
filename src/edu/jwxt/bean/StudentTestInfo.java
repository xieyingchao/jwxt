package edu.jwxt.bean;

/**
 * 考试信息类，用于存储与学生考试信息相关信息的容器
 * 
 *
 */
public class StudentTestInfo {

	int sid;
	String name;
	String address;
	String time;
	String kind;
	String ppnum;
	String coid;
	String scid;
	
	
	public String getScid() {
		return scid;
	}
	public void setScid(String scid) {
		this.scid = scid;
	}
	public String getCoid() {
		return coid;
	}
	public void setCoid(String coid) {
		this.coid = coid;
	}
	public StudentTestInfo(String name, String address, String time, String ppnum,String coid,String kind) {
		super();
		this.name = name;
		this.address = address;
		this.time = time;
		this.ppnum = ppnum;
		this.coid = coid;
		this.kind = kind;
	}
	public String getPpnum() {
		return ppnum;
	}
	public void setPpnum(String ppnum) {
		this.ppnum = ppnum;
	}
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
