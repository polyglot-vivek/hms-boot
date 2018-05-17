package com.nareshit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.bean.HospitalBean;
import com.nareshit.service.HospitalService;

@Controller
@RequestMapping("/hospCntrl")
public class HospitalController {

	@Autowired
	private HospitalService hospService;
	
	@RequestMapping("/getAllHospitals")
	public String getAllHospitals() {
		System.out.println("i am in get all hospitals");
		List<HospitalBean> hospBeanList = hospService.getAllHospitals();
		if(hospBeanList != null && !hospBeanList.isEmpty()) {
			for(HospitalBean hb : hospBeanList) {
				System.out.println(hb);
			}
		}
		return "superAdminBoardWithHospList";
	}
}
