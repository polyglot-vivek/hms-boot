package com.nareshit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permission {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int perId;
	private String perType;
	public int getPerId() {
		return perId;
	}
	public void setPerId(int perId) {
		this.perId = perId;
	}
	public String getPerType() {
		return perType;
	}
	public void setPerType(String perType) {
		this.perType = perType;
	}
	
	
	
}
