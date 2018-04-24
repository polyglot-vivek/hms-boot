package com.nareshit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nareshit.bean.HospitalBean;
import com.nareshit.dao.HospitalDao;
import com.nareshit.dao.HospitalDaoImpl;
import com.nareshit.domain.Hospital;
import com.nareshit.utility.ServiceUtil;

//@Service
@Component
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalDao hospDao;
	/*public HospitalServiceImpl() {
		hospDao = new HospitalDaoImpl();
	}*/
	
	@Override
	public HospitalBean saveHospital(HospitalBean hospBean) {
		Hospital hosp = mapBeanToDomain(hospBean);
		hosp = hospDao.addHospital(hosp);
		hospBean = mapDomainToBean(hosp);
		return hospBean;
	}

	@Override
	public HospitalBean getHospitalById(int hospId) {
		Hospital hosp = hospDao.getHospitalById(hospId);
		return mapDomainToBean(hosp);
	}

	@Override
	public boolean deleteHospital(int hospId) {
		// TODO Auto-generated method stub
		return hospDao.deleteHospital(hospId);
	}

	@Override
	public List<HospitalBean> searchAllHospitals(String hospname, String email, String city) {
		List<Hospital> hospDomainList = hospDao.searchAllHospitals(hospname, email, city);
		List<HospitalBean> hospBeansList = new ArrayList<HospitalBean>();
		for(Hospital hosp:hospDomainList) {
			hospBeansList.add(mapDomainToBean(hosp));
		}
		return hospBeansList;
	}

	@Override
	public List<HospitalBean> getAllHospitalsByPaging(int currPage, int noOfRecPage) {
		List<Hospital> hospDomainList = hospDao.getAllHospitalsByPaging(currPage, noOfRecPage);
		List<HospitalBean> hospBeansList = new ArrayList<HospitalBean>();
		for(Hospital hosp:hospDomainList) {
			hospBeansList.add(mapDomainToBean(hosp));
		}
		return hospBeansList;
	}
	
	private Hospital mapBeanToDomain(HospitalBean hospBean) {
		Hospital hosp = null; 
		if(hospBean != null) {
			hosp = new Hospital();
			hosp.setHospName(hospBean.getName());
			hosp.setEmail(hospBean.getEmail());
			hosp.setCity(hospBean.getCity());
			hosp.setFax(hospBean.getFax());
			hosp.setLandMark(hospBean.getLandMark());
			hosp.setPhone(hospBean.getPhone());
			hosp.setState(hospBean.getState());
			hosp.setStatus(hospBean.isStatus());
			hosp.setTown(hospBean.getTown());
			hosp.setZipcode(hospBean.getZipcode());
			
			hosp.setCreatedBy(hospBean.getCreatedBy());
			hosp.setModifiedBy(hospBean.getModifiedBy());
			hosp.setCreatedDate(new Date());
			hosp.setModifiedDate(new Date());
		}
		
		return hosp;
		
		
	}
	
	
	private HospitalBean mapDomainToBean(Hospital hosp) {
		HospitalBean hospBean = null;
		if(hosp != null) {
			hospBean = new HospitalBean();
			hospBean.setId(hosp.getHospId());
			hospBean.setName(hosp.getHospName());
			hospBean.setEmail(hosp.getEmail());
			hospBean.setCity(hosp.getCity());
			hospBean.setFax(hosp.getFax());
			hospBean.setLandMark(hosp.getLandMark());
			hospBean.setPhone(hosp.getPhone());
			hospBean.setState(hosp.getState());
			hospBean.setStatus(hosp.isStatus());
			hospBean.setTown(hosp.getTown());
			hospBean.setZipcode(hosp.getZipcode());
			
			hospBean.setCreatedBy(hosp.getCreatedBy());
			hospBean.setModifiedBy(hosp.getModifiedBy());
			
			hospBean.setCreatedDate(ServiceUtil.convertDateToString(hosp.getCreatedDate()));
			hospBean.setModifiedDate(ServiceUtil.convertDateToString(hosp.getModifiedDate()));
			
		}
		
		return hospBean;
		
	}

}
