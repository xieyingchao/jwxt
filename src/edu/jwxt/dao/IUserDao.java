package edu.jwxt.dao;

import edu.jwxt.bean.User;

public interface IUserDao {

	public int login(User user,String user_who);
}
