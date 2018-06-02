package com.nareshit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nareshit.bean.HospitalBean;
import com.nareshit.service.HospitalService;

@Controller
@RequestMapping("/hospitalManagement")
public class HospitalController {

	@Autowired
	private HospitalService hospservice;
	
	//Display Hospital list
	@RequestMapping("/getAllHospitals")
	public String getAllHospital(Map<String,Object> m)
	{
		int recordperpage=2;
		int startpage=1;
		List<HospitalBean> hosplist=hospservice.getAllHospitalsByPaging(startpage, recordperpage);
		//get row count
		Long count=hospservice.getRowCount();
		
		//find total pages
		double d=(count / (recordperpage+0.0));
		int pages=(int) Math.ceil(d);
		
		//send  data to ui
		m.put("pages", pages);
		m.put("hospitals", hosplist);
		return "superAdminBoardWithHospList";
		
	}
	
	//get hospital by pagination
	@RequestMapping("/getAllHospitalsPagi")
	public String getHospByPagination(Map<String,Object> m,@RequestParam("pageNo") int page)
	{
		int recordperpage=2;
		//get hospital list
		if(page==0 )
		{
			page=1;
		}
		List<HospitalBean> hosplist=hospservice.getAllHospitalsByPaging(page, recordperpage);
		//get row count
		Long count=hospservice.getRowCount();
		
		// find no of record in list
		//int selectRecord=hosplist.size();	
		
		//find total pages
		double d=(count / (recordperpage+0.0));
		int pages=(int) Math.ceil(d);
		
		//send  data to ui
		m.put("pages", pages);
		m.put("hospitals", hosplist);
		return "superAdminBoardWithHospList";
	}
	
	//hospital add form
	@RequestMapping("/hospitalAddForm")
	public String showHospAddForm(Map<String,Object> m)
	{
		HospitalBean bean=new HospitalBean();
		m.put("hosp", bean);
		return "hospitalAddForm";
	}
	
	//save hospital
	@RequestMapping(value="/saveHospital", method=RequestMethod.POST)
	public String saveHospital(@ModelAttribute("hosp") HospitalBean bean)
	{
		hospservice.saveHospital(bean);
		return "redirect:getAllHospitals";
	}
	
	//delete hospital
	@RequestMapping("/deleteHopsital")
	public String deleteHospital(@RequestParam("id") int id)
	{
		hospservice.deleteHospital(id);
		return "redirect:getAllHospitals";
	}
	
	//show update hospital form
	@RequestMapping("/editHospital")
	public String showUpdateHospForm(Map<String,Object> m,@RequestParam("id") int id)
	{
		HospitalBean bean=hospservice.getHospitalById(id);
		m.put("hosp", bean);
		return "hospitalUpdateForm";
	}
	
	//update hospital
	@RequestMapping(value="/updateHospital",method=RequestMethod.POST)
	public String updateHosp(@ModelAttribute("hosp") HospitalBean bean)
	{
		hospservice.updateHospital(bean);
		return "redirect:getAllHospitals";
	}
}
