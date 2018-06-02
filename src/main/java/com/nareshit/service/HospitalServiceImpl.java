package com.nareshit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.bean.HospitalBean;
import com.nareshit.dao.HospitalDao;
import com.nareshit.domain.Hospital;


@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalDao dao;

	public HospitalBean saveHospital(HospitalBean hospBean) {
		Hospital h=mapBeanToDomain(hospBean);
		h=dao.addHospital(h);
		HospitalBean hb=mapDomainToBean(h);
		return hb;
	}

	public HospitalBean getHospitalById(int hospId) {
		Hospital h=dao.getHospitalById(hospId);
		HospitalBean hb=mapDomainToBean(h);
		return hb;
	}
	
	public HospitalBean getHospitalByName(String hospname) {
		Hospital h=dao.getHospitalByName(hospname);
		HospitalBean hb=mapDomainToBean(h);
		return hb;
	}

	public boolean deleteHospital(int hospId) {
		boolean status=dao.deleteHospital(hospId);
		return status;
	}

	public List<HospitalBean> searchAllHospitals(String hospname, String email, String city,String status) {
		List<Hospital> l =dao.searchHospital(hospname, email, city, status);
		List<HospitalBean> hb=new ArrayList<HospitalBean>();
		for(Hospital h : l)
		{
			hb.add(mapDomainToBean(h));
		}
		return hb;
	}

	public List<HospitalBean> getAllHospitalsByPaging(int currPage, int noOfRecPage) {
		List<Hospital> l=dao.getAllHospitalByPaging(currPage, noOfRecPage);
		List<HospitalBean> hb=new ArrayList<HospitalBean>();
		for(Hospital h : l)
		{
			hb.add(mapDomainToBean(h));
		}
		return hb;
	}
	public List<HospitalBean> getAllHospitals() {
		List<Hospital> l=dao.getAllHospital();
		List<HospitalBean> hb=new ArrayList<HospitalBean>();
		for(Hospital h : l)
		{
			hb.add(mapDomainToBean(h));
			System.out.println(h.getHospName());
		}
		return hb;
	}
	
	private Hospital mapBeanToDomain(HospitalBean bean)
	{
		Hospital hosp=new Hospital();
		hosp.setCity(bean.getCity());
		hosp.setCreatedBy(bean.getCreatedBy());
		hosp.setCreatedDate(new Date());
		hosp.setEmail(bean.getEmail());
		hosp.setFax(bean.getFax());
		hosp.setHospName(bean.getName());
		hosp.setState(bean.getState());
		hosp.setLandmark(bean.getLandmark());
		hosp.setModifiedBy(bean.getModifiedBy());
		hosp.setModifiedDate(new Date());
		hosp.setPhone(bean.getPhone());
		hosp.setStatus(bean.getStatus());
		hosp.setTown(bean.getTown());
		hosp.setZipcode(bean.getZipcode());
		return hosp;
		
	}
	private HospitalBean mapDomainToBean(Hospital h)
	{
		HospitalBean hb=new HospitalBean();
		BeanUtils.copyProperties(h, hb);
		hb.setName(h.getHospName());
		return hb;
	}
	
	public HospitalBean updateHospital(HospitalBean bean)
	{
		Hospital h=new Hospital();
		BeanUtils.copyProperties(bean, h);
		h.setHospName(bean.getName());
		h=dao.updateHospital(h);
		BeanUtils.copyProperties(h, bean);
		return bean;
		
	}

	public long getRowCount() {
		return dao.getRowCount();
	}

}
