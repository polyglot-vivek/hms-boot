package com.nareshit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Type;

@Entity
@PrimaryKeyJoinColumn(name="fk_id")
public class Admin extends User {

	@Column(nullable = false)
	private String fname;
	@Column(nullable = false)
	private String lname;
	private long mobile;
	@Type(type="yes_no")
	private boolean status;
	@OneToOne
	private Hospital hosp;

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Admin [fname=" + fname + ", lname=" + lname +   ",mobile="
				+ mobile + ", status=" + status + ", hosp=" + hosp + "]";
	}
	
}
