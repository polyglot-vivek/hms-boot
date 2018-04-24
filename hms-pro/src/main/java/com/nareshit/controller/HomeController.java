package com.nareshit.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.bean.PatientBean;


@Controller
public class HomeController {

	@RequestMapping(value="/")
	public String getHomePage() {
		System.out.println("i am in home controller");
		return "home";
	}
	
	//getSignUpPage
	@RequestMapping(value="/getSignUpPage")
	public String getSignUpPage(Model map) {
		System.out.println("i am in home controller");
		map.addAttribute("outPatientBean", new PatientBean());
		return "selfSignup";
	}
	
	@RequestMapping(value="/selfSignup")
	public String selfSignUp(@ModelAttribute("outPatientBean") PatientBean patBean) {
		System.out.println("pat details are:\t"+patBean.toString());
		return null;
		
	}
}
