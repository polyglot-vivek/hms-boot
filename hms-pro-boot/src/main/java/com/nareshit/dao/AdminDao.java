package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Admin;



public interface AdminDao {
	public Admin addAdmin(Admin a);
	public Admin getAdmin(int adminid);
	public boolean deleteAdmin(int adminid);
	public List<Admin> searchAdmin(String fname, String lname, String email, String mobile);
	public List<Admin> getAllAdminByPaging(int startIndex, int recordperpage);
	public boolean activeAdmin(int adminid);	
	public boolean inactiveAdmin(int adminid);
	public List<Admin> getAllAdmin();
	public void updateAdmin(Admin a);
}
