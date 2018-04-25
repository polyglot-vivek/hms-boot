package com.nareshit.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

import com.nareshit.bean.EmailBean;
import com.nareshit.bean.PatientBean;
import com.nareshit.dao.PatientDao;
import com.nareshit.domain.Patient;
import com.nareshit.utility.ServiceUtil;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patDao;
	
	
	@Override
	public PatientBean regPatient(PatientBean patBean) {
       Patient pat = mapBeanToDomain(patBean);
       pat = patDao.savePatient(pat);
       
       patBean = mapDomainToBean(pat);
      /* if(patBean.getPatId() >0) {
    	   EmailBean mailBean = new EmailBean();
    	   mailBean.setTo(patBean.getEmail());
    	   mailBean.setSubject("");
       }*/
       
		return patBean;
	}
	
	private Patient mapBeanToDomain(PatientBean patBean) {
		Patient pat = new Patient();
		pat.setFname(patBean.getFirstName());
		pat.setLname(patBean.getLastName());
		pat.setUserId(patBean.getUserId());
		pat.setPassword(patBean.getPassword());
		pat.setCpassword(patBean.getConfirmPassword());
		pat.setEmail(patBean.getEmail());
		pat.setMobile(patBean.getMobilenumber());
		pat.setPat_type(patBean.getPat_type());
		pat.setCreatedBy(patBean.getEmail());
		pat.setModifiedBy(patBean.getEmail());
		//pat.setCreatedDate(ServiceUtil.convertStringToDate(patBean.getCreatedDate()));
		//pat.setModifiedDate(ServiceUtil.convertStringToDate(patBean.getModifiedDate()));
		pat.setCreatedDate(new Date());
		pat.setModifiedDate(new Date());
		return pat;
	}
	
	private PatientBean mapDomainToBean(Patient patient) {
		PatientBean patBean = new PatientBean();
		patBean.setPatId(patient.getId());
		patBean.setFirstName(patient.getFname());
		patBean.setLastName(patient.getLname());
		patBean.setUserId(patient.getUserId());
		patBean.setPassword(patient.getPassword());
		patBean.setConfirmPassword(patient.getCpassword());
		patBean.setEmail(patient.getEmail());
		patBean.setMobilenumber(patient.getMobile());
		patBean.setCreatedBy(patient.getCreatedBy());
		patBean.setModifiedBy(patient.getModifiedBy());
		patBean.setCreatedDate(ServiceUtil.convertDateToString(patient.getCreatedDate()));
		patBean.setModifiedDate(ServiceUtil.convertDateToString(patient.getModifiedDate()));
		patBean.setPat_type(patient.getPat_type());
		return patBean;
	}

}
