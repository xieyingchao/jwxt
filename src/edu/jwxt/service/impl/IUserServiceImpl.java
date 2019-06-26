package edu.jwxt.service.impl;

import edu.jwxt.bean.User;
import edu.jwxt.dao.IUserDao;
import edu.jwxt.dao.impl.IUserDaoImpl;
import edu.jwxt.service.IUserService;

public class IUserServiceImpl implements IUserService{
	IUserDao iuserdao = new IUserDaoImpl();
	@Override
	public int login(User user,String user_who) {
		//System.out.println(iuserdao.login(user,user_who));
		return iuserdao.login(user,user_who);
	}
}
