package edu.jwxt.service.impl;

import edu.jwxt.bean.PicCode;
import edu.jwxt.dao.IPicCodeDao;
import edu.jwxt.dao.impl.IPicCodeDaoImpl;
import edu.jwxt.service.IPicCodeService;

public class IPicCodeServiceImpl implements IPicCodeService{

	@Override
	public PicCode CheckPicCode() {
		IPicCodeDao ipiccodedao = new IPicCodeDaoImpl();
		PicCode piccode = ipiccodedao.GetCode();
		return piccode;
	}
}
