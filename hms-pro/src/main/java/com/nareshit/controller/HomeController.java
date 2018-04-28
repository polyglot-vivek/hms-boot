package com.nareshit.controller;

import java.util.Base64;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.bean.EmailBean;
import com.nareshit.bean.PatientBean;
import com.nareshit.service.EmailService;
import com.nareshit.service.PatientService;
import com.nareshit.utility.ServiceConstants;


@Controller
public class HomeController {

	@Autowired
	private PatientService patService;
	

	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value="/")
	public String getHomePage() {
		System.out.println("i am in home controller");
		
		
		
		return "home";
	}
	///getDashBoard
	@RequestMapping(value="/getDashBoard")
	public String getDashBoard(Model model) {
		Authentication authManager = SecurityContextHolder.getContext().getAuthentication();
		
		
		//User user = (User)authManager.getPrincipal();
		
		String dashBoardPage = "dashBoard";
		
		String role = null;
		for(GrantedAuthority ga : authManager.getAuthorities()) {
			role = ga.getAuthority();
		}
		
		if(role != null && role.equals(ServiceConstants.SUPER_ADMIN_ROLE)) {
			dashBoardPage = "superAdminBoard";
			
		}
		if(role != null && 
				role.
				equals(ServiceConstants.ADMIN_ROLE)) {
			dashBoardPage = "adminBoard";
		}
		model.addAttribute("loggedInUser", authManager.getName());
		model.addAttribute("loggedInUserRole", role);
	
		return dashBoardPage;
	}
	
	@RequestMapping(value="/getWindowLogin")
	public String getWindowLogin(Model model) {
		Authentication authManager = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authManager.getPrincipal();
		
		String dashBoardPage = "dashBoard";
		
		String role = null;
		for(GrantedAuthority ga : user.getAuthorities()) {
			role = ga.getAuthority();
		}
		
		if(user != null && role.equals(ServiceConstants.SUPER_ADMIN_ROLE)) {
			dashBoardPage = "superAdminBoard";
			
		}
		if(user != null && 
				role.
				equals(ServiceConstants.ADMIN_ROLE)) {
			dashBoardPage = "adminBoard";
		}
		model.addAttribute("loggedInUser", user.getUsername());
		model.addAttribute("loggedInUserRole", role);
	
		return dashBoardPage;
	}
	
	//getSignUpPage
	@RequestMapping(value="/getSignUpPage")
	public String getSignUpPage(Model map) {
		System.out.println("i am in home controller");
		map.addAttribute("outPatientBean", new PatientBean());
		return "selfSignup";
	}
	
	@RequestMapping(value="/selfSignup")
	public String selfSignUp(@ModelAttribute("outPatientBean") PatientBean patBean,Model map) {
		System.out.println("pat details are:\t"+patBean.toString());
		patBean.setPat_type("outPatient");
		patBean = patService.regPatient(patBean);
		String resPage = "selfSignup";
		if(patBean != null && patBean.getPatId() >0) {
		   EmailBean mailBean = new EmailBean();
     	   mailBean.setTo(patBean.getEmail());
     	   mailBean.setSubject(ServiceConstants.REG_SUCCESS_MAIL_SUB);
           String activationLink = ServiceConstants.HMS_PRO_ACTIVATION_LINK+patBean.getUserId();
     	   
           StringBuilder sb = new StringBuilder();
     	   sb.append(ServiceConstants.HMS_PRO_MAIL_BODY);
     	   sb.append("\n");
     	   sb.append(activationLink);
     	   mailBean.setBody(sb.toString());
     	  boolean hasMailSent =  emailService.sendEmail(mailBean);
          if(hasMailSent) {
        	  map.addAttribute("patRegStatus", ServiceConstants.REG_SUCCESS_MAIL_SUB);
          }
     	  
		}
		return resPage;
		
	}
	
	@RequestMapping(value="/activateUser/{userId}")
	public String activateUser(@PathVariable("userId") String userId) {
		System.out.println("user id is:\t"+userId);
		boolean isPatExisted = false;
		if(userId != null && !userId.isEmpty()) {
			isPatExisted = patService.isPatientExisted(userId);
		}
		if(isPatExisted) {
			boolean isUserActivated = patService.activateUser(userId);
			if(isUserActivated) {
				return "login";
			}
		}
		
		return "home";
	}
	
	public static void main(String[] args) {
		String username = "john:john";
		System.out.println(Base64.getEncoder().encodeToString(username.getBytes()));
	}
}
