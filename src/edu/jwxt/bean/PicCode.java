package edu.jwxt.bean;

/**
 * 图片验证码类，存储验证码图片地址，答案以及验证码的id号
 * @author 谢迎超
 *
 */
public class PicCode {

	int yzid;
	String da_an;
	String address;
	public PicCode(int yzid, String da_an, String address) {
		super();
		this.yzid = yzid;
		this.da_an = da_an;
		this.address = address;
	}
	public int getYzid() {
		return yzid;
	}
	public void setYzid(int yzid) {
		this.yzid = yzid;
	}
	public String getDa_an() {
		return da_an;
	}
	public void setDa_an(String da_an) {
		this.da_an = da_an;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
