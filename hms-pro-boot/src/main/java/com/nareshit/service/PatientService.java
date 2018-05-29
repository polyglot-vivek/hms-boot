package com.nareshit.service;

import com.nareshit.bean.PatientBean;

public interface PatientService {

	public PatientBean regPatient(PatientBean patBean);
	public boolean isPatientExisted(String userId);
	public boolean activateUser(String userId);
}
