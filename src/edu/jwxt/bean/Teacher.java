package edu.jwxt.bean;

public class Teacher {

	int tid;
	String name;
	String num;
	int sex;
	String sept;
	int age;
	String id;
	String password;
	String pic;
	String email;
	String tel;
	String address;
	
	
	String newpwd;
	
	
	
	
	public Teacher(int tid, String password, String newpwd) {
		super();
		this.tid = tid;
		this.password = password;
		this.newpwd = newpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public Teacher(int tid, String name, String num, int sex, String sept, int age, String id, String password,
			String pic, String email, String tel, String address) {
		super();
		this.tid = tid;
		this.name = name;
		this.num = num;
		this.sex = sex;
		this.sept = sept;
		this.age = age;
		this.id = id;
		this.password = password;
		this.pic = pic;
		this.email = email;
		this.tel = tel;
		this.address = address;
	}
	public Teacher(int tid, String email, String tel, String address) {
		super();
		this.tid = tid;
		this.email = email;
		this.tel = tel;
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Teacher(int tid, String name, String num, int sex, String sept, int age, String id, String password,
			String pic) {
		super();
		this.tid = tid;
		this.name = name;
		this.num = num;
		this.sex = sex;
		this.sept = sept;
		this.age = age;
		this.id = id;
		this.password = password;
		this.pic = pic;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
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
	public String getSept() {
		return sept;
	}
	public void setSept(String sept) {
		this.sept = sept;
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
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", num=" + num + ", sex=" + sex + ", sept=" + sept + ", age="
				+ age + ", id=" + id + ", password=" + password + ", pic=" + pic + "]";
	}
	
	
}
