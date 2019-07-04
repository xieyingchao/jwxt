package edu.jwxt.bean;

/**
 * 用户类，主要用于用户初期的登录
 * @author 谢迎超
 *
 */
public class User {

	String name;
	String num;
	int sex;
	String cname;
	int age;
	String id;
	String password;
	String pic;
	public User(String num,String pwd) {
		this.num = num;
		this.password = pwd;
	}
	public User(String name, String num, int sex, String cname, int age, String id, String password, String pic) {
		super();
		this.name = name;
		this.num = num;
		this.sex = sex;
		this.cname = cname;
		this.age = age;
		this.id = id;
		this.password = password;
		this.pic = pic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
}
