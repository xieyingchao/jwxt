package edu.jwxt.service;

import edu.jwxt.bean.PicCode;

public interface IPicCodeService {
	/**
	 * 检查验证码
	 */
	public PicCode CheckPicCode();
}
