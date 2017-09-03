package com.jiang.entity;

public class UserBean extends BaseBean {
	private static final long serialVersionUID = -264871429184110588L;
	private String username;
	private String password;
	private String realname;
	private Boolean sex;
	private String addr;
	private String postcode;
	private String tel;
	private String email;
	private Boolean locked;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	@Override
	public String toString() {
		return "UserBean [username=" + username + ", password=" + password
				+ ", realname=" + realname + ", sex=" + sex + ", addr=" + addr
				+ ", postcode=" + postcode + ", tel=" + tel + ", email="
				+ email + ", locked=" + locked + "]";
	}
	
}
