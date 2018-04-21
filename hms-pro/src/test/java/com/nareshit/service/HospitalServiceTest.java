package com.nareshit.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nareshit.bean.HospitalBean;
import com.nareshit.utility.ServiceUtil;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class HospitalServiceTest {

	private static HospitalService hospService = null;
	
	@BeforeClass
	public static void setUp() {
		System.out.println("setup() calling");
		hospService = new HospitalServiceImpl();
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("teardown is calling");
		hospService = null;
	}
	
	//@Test
	@Ignore
	public void testSaveHospital() {
		
		
		HospitalBean hospBean = new HospitalBean();
		hospBean.setName("appollo");
		hospBean.setEmail("hospital@appollo.com");
		hospBean.setCity("Hyderabad");
		hospBean.setFax("040-6754321");
		hospBean.setLandMark("beside satyam theater");
		hospBean.setPhone(9876543210l);
		hospBean.setState("Telangana");
		hospBean.setStatus(true);
		hospBean.setTown("Ameerpet");
		hospBean.setZipcode(5000000);
		
		hospBean.setCreatedBy("admin@appollo.com");
		hospBean.setModifiedBy("admin@appollo.com");
		
		hospBean = hospService.saveHospital(hospBean);
		Assert.assertNotNull(hospBean);
		
		
	}
	
	@Test
	public void testGetHospitalById() {
		int hospId = 2;
		HospitalBean hospBean = hospService.getHospitalById(hospId);
		if(hospBean == null) {
		  Assert.assertNull(hospBean);	
		}else {
			Assert.assertNotNull(hospBean);
			Assert.assertEquals(1, hospBean.getId());
		}
	
		
	}
	
}
