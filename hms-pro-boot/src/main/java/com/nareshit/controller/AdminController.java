package com.nareshit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nareshit.bean.AdminBean;
import com.nareshit.bean.HospitalBean;
import com.nareshit.service.AdminService;
import com.nareshit.service.HospitalService;

@Controller
@RequestMapping("/adminManagement")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private HospitalService hospService;
	
	//get admins
	@RequestMapping("/getAllAdmin")
	public String getAllAdmins(Model m)
	{
		List<AdminBean> admins=adminService.getAllAdmmins();
		m.addAttribute("admins", admins);
		return "adminDataBoard";	
	}
	//get Admins by pagination
	/*@RequestMapping("/getAllAdmin")
	public String adminsByPage(Model m)
	{
		int
		adminService.getAllAdminByPaging(startIndex, recordperpage)
		
		return "adminDataBoard";
	}*/
	//show add admin form
	@RequestMapping("/adminAddForm")
	public String showAddAdminForm(Model m)
	{
		AdminBean bean=new AdminBean();
		m.addAttribute("admin", bean);
		return "adminAddForm";
	}
	
	//add data to the form 
	@ModelAttribute("hosp")
	public List<String> hospList()
	{
		List<HospitalBean> l=hospService.getAllHospitals();
		List<String> hname=new ArrayList();
		for(HospitalBean bean : l)
		{
			hname.add(bean.getName());
		}
		return hname;
	}
	
	@ModelAttribute("stat")
	public List<String> adminStatus()
	{
		List<String> statusList=new ArrayList();
		statusList.add("true");
		statusList.add("false");
		return statusList;
	}
	//save admin 
	@RequestMapping(value="/saveAdmin",method=RequestMethod.POST)
	public String saveAdmin(@ModelAttribute("admin") AdminBean bean)
	{
		System.out.println("controller "+bean);
		HospitalBean hb=hospService.getHospitalByName(bean.getHospName());
		bean.setHosp(hb);
		adminService.addAdmin(bean);
		return "redirect:getAllAdmin";
	}
	
	//delete admin
	@RequestMapping("/deleteAdmin")
	public String deleteAdmin(@RequestParam("id") Integer id)
	{
		adminService.deleteAdmin(id);
		return "redirect:getAllAdmin";
	}

	//show admin update form
	@RequestMapping("/editadmin")
	public String updateAdminForm(Model m,@RequestParam("id") int id)
	{
		AdminBean bean=adminService.getAdmin(id);
		m.addAttribute("admin", bean);
		return "adminUpdateForm";
	}
	
	//update admin
	@RequestMapping(value="/updateAdmin",method=RequestMethod.POST)
	public String updateAdminDetail(@ModelAttribute("admin") AdminBean bean)
	{  
		HospitalBean hb=hospService.getHospitalByName(bean.getHospName());
		bean.setHosp(hb);
		System.out.println("controller "+bean);
		adminService.updateAdmin(bean);
		
		return "redirect:getAllAdmin";
	}
}
