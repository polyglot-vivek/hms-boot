package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Hospital;

public interface HospitalDao {
	public Hospital addHospital(Hospital h);
	public List<Hospital> getAllHospital();
	public Hospital getHospitalById(int id);
	public Hospital updateHospital(Hospital h);
	public boolean deleteHospital(int id);
	public List<Hospital> searchHospital(String hospName, String email, String city, String status);	
	public List<Hospital> getAllHospitalByPaging(int startIndex, int recordperpage);
	public long getRowCount();
	public boolean activeHospital(int id);	
	public boolean inactiveHospital(int id);
	public Hospital getHospitalByName(String hospname);
}
