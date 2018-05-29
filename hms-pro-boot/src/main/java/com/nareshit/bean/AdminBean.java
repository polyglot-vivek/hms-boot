package com.nareshit.bean;

public class AdminBean {

	private Integer adminid;
	private String fname;
	private String lname;
	private String userid;
	private String password;
	private boolean status;
	private String email;
	private Long mobile;
	private String hospName;
	private HospitalBean hosp;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public HospitalBean getHosp() {
		return hosp;
	}
	public void setHosp(HospitalBean hosp) {
		this.hosp = hosp;
	}
	public Integer getAdminid() {
		return adminid;
	} 
	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getHospName() {
		return hospName;
	}
	public void setHospName(String hospName) {
		this.hospName = hospName;
	}
	@Override
	public String toString() {
		return "AdminBean [adminid=" + adminid + ", fname=" + fname + ", lname=" + lname + ", userid=" + userid
				+ ", password=" + password + ", status=" + status + ", email=" + email + ", mobile=" + mobile
				+ ", hospName=" + hospName + ", hosp=" + hosp + "]";
	}

}
