package edu.jwxt.bean;

/**
 * 学生类，用于存储学生相关信息的容器
 * @author 谢迎超
 *
 */
public class Student {

	int sid;
	String name;
	String num;
	int sex;
	String cname;
	int age;
	String id;
	String password;
	String pic;
	String email;
	String address;
	String tel;
	public Student(String name, String num, int sex, String cname) {
		super();
		this.name = name;
		this.num = num;
		this.sex = sex;
		this.cname = cname;
	}
	String newpwd;
	
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public Student(int sid, String password, String newpwd) {
		super();
		this.sid = sid;
		this.password = password;
		this.newpwd = newpwd;
	}
	public Student(int sid, String email, String address, String tel) {
		super();
		this.sid = sid;
		this.email = email;
		this.address = address;
		this.tel = tel;
	}
	public Student(int sid, String name, String num, int sex, String cname, int age, String id, String password,
			String pic, String email, String address, String tel) {
		super();
		this.sid = sid;
		this.name = name;
		this.num = num;
		this.sex = sex;
		this.cname = cname;
		this.age = age;
		this.id = id;
		this.password = password;
		this.pic = pic;
		this.email = email;
		this.address = address;
		this.tel = tel;
	}
	public Student(int sid, String name, String num, int sex, String cname, int age, String id, String password,String pic) {
		super();
		this.sid = sid;
		this.name = name;
		this.num = num;
		this.sex = sex;
		this.cname = cname;
		this.age = age;
		this.id = id;
		this.password = password;
		this.pic = pic;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
