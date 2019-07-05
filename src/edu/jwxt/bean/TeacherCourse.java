package edu.jwxt.bean;

/**
 * 教师课程类，用于存储与教师课程相关信息的容器
 * 
 *
 */
public class TeacherCourse {

	String name;
	double xuefen;
	String num;
	String xuenian;
	String xueqi;
	String time;
	String classroom;
	String ppnum;
	public TeacherCourse(String name, double xuefen, String num, String xuenian, String xueqi, String time,
			String classroom, String ppnum) {
		super();
		this.name = name;
		this.xuefen = xuefen;
		this.num = num;
		this.xuenian = xuenian;
		this.xueqi = xueqi;
		this.time = time;
		this.classroom = classroom;
		this.ppnum = ppnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getXuefen() {
		return xuefen;
	}
	public void setXuefen(double xuefen) {
		this.xuefen = xuefen;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getXuenian() {
		return xuenian;
	}
	public void setXuenian(String xuenian) {
		this.xuenian = xuenian;
	}
	public String getXueqi() {
		return xueqi;
	}
	public void setXueqi(String xueqi) {
		this.xueqi = xueqi;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public String getPpnum() {
		return ppnum;
	}
	public void setPpnum(String ppnum) {
		this.ppnum = ppnum;
	}
	public TeacherCourse(String name, double xuefen, String num, String time, String classroom, String ppnum) {
		super();
		this.name = name;
		this.xuefen = xuefen;
		this.num = num;
		this.time = time;
		this.classroom = classroom;
		this.ppnum = ppnum;
	}
	
	
	
}
