package com.nareshit.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nareshit.domain.Bed;
import com.nareshit.domain.BedCategory;
import com.nareshit.domain.Patient;
import com.nareshit.utility.HibernateUtility;


public class BedManagementDaoImpl implements BedManagementDao {

	private static SessionFactory sf = null;

	@Override
	public Bed addBed(Bed bd) {
		sf = HibernateUtility.getInstance();
		Session ses = sf.openSession();
		ses.save(bd);
		ses.beginTransaction().commit();
		ses.close();
		return bd;
	}

	@Override
	public BedCategory addBedCategory(BedCategory bdc) {
		sf = HibernateUtility.getInstance();
		Session ses = sf.openSession();
		ses.save(bdc);
		ses.beginTransaction().commit();
		ses.close();
		return bdc;
	}
	
	@Override
	public Bed getBedById(int bedId) {
		sf = HibernateUtility.getInstance();
		Session ses = sf.openSession();
		Bed bd = (Bed)ses.get(Bed.class, bedId);
		ses.beginTransaction().commit();
		ses.close();
		return bd;
	}

	@Override
	public BedCategory getBedTypeByCatId(int bdCatId) {
		sf = HibernateUtility.getInstance();
		Session ses = sf.openSession();
		BedCategory bd = (BedCategory)ses.get(BedCategory.class, bdCatId);
		ses.beginTransaction().commit();
		ses.close();
		return bd;
	}
	
	public BedCategory updateBedCat(BedCategory bdc) {
		sf = HibernateUtility.getInstance();
		Session ses = sf.openSession();
		ses.update(bdc);
		ses.beginTransaction().commit();
		ses.close();
		return bdc;
	}
	
	
	@Override
	public Bed mapBedIntoCategory(int catId, int bedId) {
        Bed bd = getBedById(bedId);
        BedCategory bdc = getBedTypeByCatId(catId);
        
        List<Bed> bdList = new ArrayList<Bed>();
        
        String catType = bdc.getCategory();
        int bedNum = bd.getBedNum();
        String bedName = catType+"-"+bedNum;
        bd.setBedName(bedName);
        
        bd.setModifiedBy("Jack@email.com");
        bd.setModifiedDate(new Date());
        bdList.add(bd);
        
        bdc.setBedList(bdList);
        bdc.setModifiedBy("Jack@email.com");
        bdc.setModifiedDate(new Date());
        
        bdc = updateBedCat(bdc);
        return bd;
	}

	@Override
	public Bed unMapBedIntoCategory(int catId, int bedId) {
		sf = HibernateUtility.getInstance();         
	    Session ses = sf.openSession();
		
	    Bed wantToDeleteBed = (Bed)ses.get(Bed.class, bedId);
	    //Bed wantToDeleteBed = getBedById(bedId);
	    BedCategory bdc = (BedCategory)ses.get(BedCategory.class, catId);
	    
	   // BedCategory bdc = getBedTypeByCatId(catId);
        List<Bed> bedList = bdc.getBedList();
               
        List<Bed> removedBeds = new ArrayList<Bed>();
        
        if(bedList != null && !bedList.isEmpty()) {
        	for(Bed alreadyAvailbelBed : bedList) {
        		if(alreadyAvailbelBed.getbId() == wantToDeleteBed.getbId()) {
        			removedBeds.add(alreadyAvailbelBed);
        		}
        	}
        }
       bedList.removeAll(removedBeds);
       bdc.setBedList(bedList);
      
       ses.update(bdc);
       ses.beginTransaction().commit();
       ses.close();
        //bdc = updateBedCat(bdc);
        
		return wantToDeleteBed;
	}

	@Override
	public Patient assignBedToPatient(int bedId, int patId) {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}
