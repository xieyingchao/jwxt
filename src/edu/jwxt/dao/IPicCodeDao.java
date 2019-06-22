package edu.jwxt.dao;

import edu.jwxt.bean.PicCode;

public interface IPicCodeDao {

	/**
	 * 从数据库中取出验证码
	 */
	public PicCode GetCode();
}
