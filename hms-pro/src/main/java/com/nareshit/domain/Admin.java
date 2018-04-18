package com.nareshit.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Admin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", fname=" + fname + ", lname=" + lname + ", userId=" + userId + ", password="
				+ password + ", cpassword=" + cpassword + ", email=" + email + ", mobile=" + mobile + ", hosp=" + hosp
				+ "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(unique=true,nullable=false)
	private String fname;
	private String lname;
	@Column(unique=true,nullable=false)
	private String userId;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String cpassword;
	
	@Column(unique=true,nullable=false)
	private String email;
	@Column(unique=true,nullable=false)
	private long mobile;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Hospital hosp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public Hospital getHosp() {
		return hosp;
	}

	public void setHosp(Hospital hosp) {
		this.hosp = hosp;
	}
}
