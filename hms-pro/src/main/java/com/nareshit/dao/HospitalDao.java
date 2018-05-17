package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Hospital;

public interface HospitalDao {

	public Hospital addHospital(Hospital hosp);
	public Hospital getHospitalById(int hospId);
	public boolean deleteHospital(int hospId);
	
	public List<Hospital>  searchAllHospitals(String hospname,String email, String city);
	
	public List<Hospital>  getAllHospitalsByPaging(int currPage,int noOfRecPage);
	List<Hospital> getAllHospitals();
	
}
