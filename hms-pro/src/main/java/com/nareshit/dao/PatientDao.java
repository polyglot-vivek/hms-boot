package com.nareshit.dao;

import com.nareshit.domain.Patient;

public interface PatientDao {

	public Patient savePatient(Patient pat);
	public boolean isPatientExisted(String userId);
	public boolean activateUser(String userId);
	Patient getPatientByUserId(String userId);
	
}
