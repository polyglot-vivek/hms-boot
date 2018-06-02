package com.nareshit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.bean.AdminBean;
import com.nareshit.bean.HospitalBean;
import com.nareshit.dao.AdminDao;
import com.nareshit.dao.HospitalDao;
import com.nareshit.domain.Admin;
import com.nareshit.domain.Hospital;


@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao dao;
	@Autowired
	private HospitalDao hospDao;

	public AdminBean addAdmin(AdminBean bean) 
	{
		Admin a = mapBeanToDomain(bean);
		a = dao.addAdmin(a);
		AdminBean ab = mapDomainToBean(a);
		return ab;
	}

	public AdminBean getAdmin(int adminid) {
		Admin a = dao.getAdmin(adminid);
		AdminBean ab = mapDomainToBean(a);
		return ab;
	}
	
	
	public boolean deleteAdmin(int adminid) {

		return dao.deleteAdmin(adminid);
	}
	
	private Admin mapBeanToDomain(AdminBean bean) {
		Hospital h=new Hospital();
		HospitalBean hb=bean.getHosp();
		BeanUtils.copyProperties(hb, h);
		Admin a = new Admin();
		a.setStatus(bean.isStatus());
		a.setFname(bean.getFname());
		a.setLname(bean.getLname());
		a.setMobile(bean.getMobile());
		a.setEmail(bean.getEmail());
		a.setUserId(bean.getUserid());
		a.setPassword(bean.getPassword());
		a.setHosp(h);
		return a;
	}

	private AdminBean mapDomainToBean(Admin a) {
		Hospital h=a.getHosp();
		HospitalBean hb=new HospitalBean();
		BeanUtils.copyProperties(h, hb);
		AdminBean bean = new AdminBean();
		bean.setAdminid(a.getId());
		bean.setFname(a.getFname());
		bean.setLname(a.getLname());
		bean.setMobile(a.getMobile());
		bean.setEmail(a.getEmail());
		bean.setUserid(a.getUserId());
		bean.setPassword(a.getPassword());
		bean.setStatus(a.isStatus());
		bean.setHospName(hb.getName());
		return bean;
	}

	public List<AdminBean> searchAdmin(String fname, String lname, String email, String mobile) {
		List<Admin> a = dao.searchAdmin(fname, lname, email, mobile);
		List<AdminBean> l = new ArrayList<AdminBean>();
		for (Admin ab : a) {
			l.add(mapDomainToBean(ab));
		}
		return l;
	}

	public List<AdminBean> getAllAdminByPaging(int startIndex, int recordperpage) {
		List<Admin> l = dao.getAllAdminByPaging(startIndex, recordperpage);
		List<AdminBean> ab = new ArrayList<AdminBean>();
		for (Admin a : l) {
			ab.add(mapDomainToBean(a));
		}
		return ab;
	}

	public boolean activeAdmin(int adminid) {
		return dao.activeAdmin(adminid);
	}

	public boolean inactiveAdmin(int adminid) {
		return dao.inactiveAdmin(adminid);
	}

	public List<AdminBean> getAllAdmmins() {
		
		List<Admin> admins= dao.getAllAdmin();
		List<AdminBean> alist = new ArrayList<AdminBean>();
		for (Admin a : admins) {
			alist.add(mapDomainToBean(a));
		}
		return alist;
	}
	
	public void updateAdmin(AdminBean bean)
	{
		Admin a= mapBeanToDomain( bean);
		/*Hospital h=new Hospital();
		HospitalBean hb=bean.getHosp();
		BeanUtils.copyProperties(hb, h);
		Admin a = new Admin();
		BeanUtils.copyProperties(bean, a);
		a.setHosp(h);
		a.setUserId(bean.getUserid());
		a.setPassword(bean.getPassword());*/
		a.setId(bean.getAdminid());
		System.out.println("service 1 "+a);
		dao.updateAdmin(a);
	}

	
}
