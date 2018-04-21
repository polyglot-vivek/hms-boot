package com.nareshit.service;

import java.util.List;

import com.nareshit.bean.HospitalBean;

public interface HospitalService {

	public HospitalBean saveHospital(HospitalBean hospBean);
	public HospitalBean getHospitalById(int hospId);
	public boolean deleteHospital(int hospId);
	
	public List<HospitalBean>  searchAllHospitals(String hospname,String email, String city);
	
	public List<HospitalBean>  getAllHospitalsByPaging(int currPage,int noOfRecPage);
}
