package com.nareshit.service;
import java.util.List;

import com.nareshit.bean.AdminBean;

public interface AdminService {
	
	public AdminBean addAdmin(AdminBean bean);
	public AdminBean getAdmin(int adminid);
	public boolean deleteAdmin(int adminid);
	public List<AdminBean> searchAdmin(String fname, String lname, String email, String mobile);
	public List<AdminBean> getAllAdminByPaging(int startIndex, int recordperpage);
	public boolean activeAdmin(int adminid);
	public boolean inactiveAdmin(int adminid);
	public List<AdminBean> getAllAdmmins();
	public void updateAdmin(AdminBean bean);
}