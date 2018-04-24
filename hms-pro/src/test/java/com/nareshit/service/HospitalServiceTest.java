package com.nareshit.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nareshit.bean.HospitalBean;


public class HospitalServiceTest {

	//private static HospitalService hospService = null;
	
	/*ApplicationContext ctx = null;
	HospitalService hospService = null;
	
	@Before
	public void setUp() {
		System.out.println("setup() calling");
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		hospService = (HospitalService)ctx.getBean(HospitalService.class);
	}
	
	@After
	public void tearDown() {
		System.out.println("teardown is calling");
		hospService = null;
		ctx = null;
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
	//@Test
	@org.junit.Ignore
	public void testGetHospitalById() {
		int hospId = 2;
		HospitalBean hospBean = hospService.getHospitalById(hospId);
		if(hospBean == null) {
		  Assert.assertNull(hospBean);	
		}else {
			Assert.assertNotNull(hospBean);
			Assert.assertEquals(1, hospBean.getId());
		}
	
		
	}*/
	
}
