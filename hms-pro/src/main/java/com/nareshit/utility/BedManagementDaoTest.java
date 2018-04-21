package com.nareshit.utility;

import java.util.Date;

import com.nareshit.dao.BedManagementDao;
import com.nareshit.dao.BedManagementDaoImpl;
import com.nareshit.domain.Bed;
import com.nareshit.domain.BedCategory;
import com.nareshit.domain.Patient;

public class BedManagementDaoTest {

	
	
	
	public static void main(String[] args) {
	
		BedManagementDao bdMgmtDao = new BedManagementDaoImpl();
		/**
		 * Bed Creation
		 */
		/*Bed b = new Bed();
		b.setBedNum(01);
		b.setStatus(true);
		b.setCreatedBy("John@email.com");
		b.setCreatedDate(new Date());
		b.setModifiedBy(b.getCreatedBy());
		b.setModifiedDate(b.getModifiedDate());
		
		b = bdMgmtDao.addBed(b);
		if(b.getbId() >0) {
			System.out.println("bed created");
		}*/
		
		/**
		 * BedCategory Creation
		 */
		/*BedCategory bdc = new BedCategory();
		bdc.setCategory("ICU");
		bdc.setCreatedBy("John@email.com");
		bdc.setCreatedDate(new Date());
		bdc.setModifiedBy(bdc.getCreatedBy());
		bdc.setModifiedDate(bdc.getCreatedDate());
		

		bdc = bdMgmtDao.addBedCategory(bdc);
		if(bdc.getCatId() >0) {
			System.out.println("bed Category created");
		}*/
		
		/**
		 * Mapping bed into the category
		 */
		
	  /* Bed bd = bdMgmtDao.mapBedIntoCategory(1, 1);
	   System.out.println(bd.getBedName());*/
		
		/**
		 * unmap bed from the bed category
		 */
		/*Bed bd = bdMgmtDao.unMapBedIntoCategory(1, 1);
		System.out.println(bd.getBedName());*/
		
		/**
		 * assigning bed to the patient
		 */
		/*Patient pat = bdMgmtDao.assignBedToPatient(1, 1);
		System.out.println("patient "+pat.getUserId()+" assigned into:\t"+pat.getBed().getBedName());
*/		
		/**
		 * unassigning patient from the bed
		 */
		Patient pat = bdMgmtDao.unAssignBedToPatient(1, 1);
		//System.out.println("patient "+pat.getUserId()+" un assigned from:\t"+pat.getBed().getBedName());
	}
}
