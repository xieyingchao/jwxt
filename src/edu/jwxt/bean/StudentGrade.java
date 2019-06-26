package edu.jwxt.bean;

public class StudentGrade {

	String name;
	double xuefen;
	int grade;
	double getxuefen;
	double jidian;
	String num;
	String teacher;
	String time;
	String classroom;
	String sept;
	String ppnum;
	
	public String getPpnum() {
		return ppnum;
	}
	public void setPpnum(String ppnum) {
		this.ppnum = ppnum;
	}
	public String getSept() {
		return sept;
	}
	public void setSept(String sept) {
		this.sept = sept;
	}
	public StudentGrade(String name, double xuefen, String num, String teacher, String time, String classroom,
			String sept,String ppnum) {
		super();
		this.name = name;
		this.xuefen = xuefen;
		this.num = num;
		this.teacher = teacher;
		this.time = time;
		this.classroom = classroom;
		this.sept = sept;
		this.ppnum = ppnum;
	}
	public StudentGrade(String name, double xuefen, String num, String teacher, String time, String classroom) {
		super();
		this.name = name;
		this.xuefen = xuefen;
		this.num = num;
		this.teacher = teacher;
		this.time = time;
		this.classroom = classroom;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
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
	public StudentGrade(String name, double xuefen, int grade, double getxuefen, double jidian) {
		super();
		this.name = name;
		this.xuefen = xuefen;
		this.grade = grade;
		this.getxuefen = getxuefen;
		this.jidian = jidian;
	}
	public StudentGrade(String name, double xuefen, int grade) {
		super();
		this.name = name;
		this.xuefen = xuefen;
		this.grade = grade;
		this.getxuefen = grade>=60?xuefen:0;
		if (grade >= 90) {
			this.jidian = 4;
		}else if(grade >= 85&& grade < 90) {
			this.jidian = 3.7;
		}else if(grade >= 80&& grade < 85) {
			this.jidian = 3;
		}else if(grade >= 75&& grade < 80) {
			this.jidian = 2.7;
		}else if(grade >= 70&& grade < 75) {
			this.jidian = 2;
		}else if(grade >= 65&& grade < 70) {
			this.jidian = 1.7;
		}else if(grade >= 60&& grade < 65) {
			this.jidian = 1;
		}else {
			this.jidian = 0;
		}
	}
	public double getGetxuefen() {
		return getxuefen;
	}
	public void setGetxuefen(int getxuefen) {
		this.getxuefen = getxuefen;
	}
	public double getJidian() {
		return jidian;
	}
	public void setJidian(double jidian) {
		this.jidian = jidian;
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
	public void setXuefen(int xuefen) {
		this.xuefen = xuefen;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
