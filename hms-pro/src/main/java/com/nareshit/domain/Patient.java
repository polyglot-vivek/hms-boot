package com.nareshit.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity
public class Patient implements Serializable {

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
	
	@Type(type="yes_no")
	private boolean isActive=false;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="pat")
	private List<PatientToDoctor> docList;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Bed bed;
	
	public Bed getBed() {
		return bed;
	}
	public void setBed(Bed bed) {
		this.bed = bed;
	}
	public List<PatientToDoctor> getDocList() {
		return docList;
	}
	public void setDocList(List<PatientToDoctor> docList) {
		this.docList = docList;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", fname=" + fname + ", lname=" + lname + ", userId=" + userId + ", password="
				+ password + ", cpassword=" + cpassword + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
	
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
	@Column(unique=true,nullable=false)
	private String email;
	@Column(unique=true,nullable=false)
	private long mobile;

	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;
	private String pat_type;

	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getPat_type() {
		return pat_type;
	}
	public void setPat_type(String pat_type) {
		this.pat_type = pat_type;
	}
}
