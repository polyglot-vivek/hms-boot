package com.nareshit.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String role;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="role")
	private List<RoleToPermission> roleToPermission;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<RoleToPermission> getRoleToPermission() {
		return roleToPermission;
	}

	public void setRoleToPermission(List<RoleToPermission> roleToPermission) {
		this.roleToPermission = roleToPermission;
	}

}
