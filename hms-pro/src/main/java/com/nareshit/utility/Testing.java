package com.nareshit.utility;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nareshit.domain.Bed;
import com.nareshit.domain.BedCategory;
import com.nareshit.domain.Doctor;
import com.nareshit.domain.Patient;
import com.nareshit.domain.PatientToDoctor;

public class Testing {

	public static boolean deletedAssignedDoctor(PatientToDoctor doc) {
		SessionFactory sf = HibernateUtility.getInstance();
		Session ses = sf.openSession();
		ses.delete(doc);
		ses.beginTransaction().commit();
		return true;
	}
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtility.getInstance();
		Session ses = sf.openSession();
		
		/*Bed b = new Bed();
		b.setBedNum(1);
		b.setStatus(true);*/
		
		/*BedCategory bc = new BedCategory();
		bc.setCategory("GEN");
		
		ses.save(bc);
		ses.beginTransaction().commit();*/
		
		BedCategory cat = (BedCategory)ses.get(BedCategory.class, 1);
		Bed b = (Bed)ses.get(Bed.class, 1);
		/*b.setBedName(cat.getCategory()+"-"+b.getBedNum());
		
		List<Bed> bedList = new ArrayList<Bed>();
		bedList.add(b);
		cat.setBedList(bedList);
		
		ses.update(cat);
		ses.beginTransaction().commit();*/
		List<Bed> removedList = new ArrayList<Bed>();
		for(Bed bd : cat.getBedList()) {
			if(bd.getbId() == b.getbId()) {
				removedList.add(bd);
			}
		}
		
		cat.getBedList().removeAll(removedList);
		ses.update(cat);
		ses.beginTransaction().commit();
		
		
		
		
		/*Doctor doc = new Doctor();
		doc.setFname("Jack");
		doc.setLname("Tax");
		doc.setEmail("jack@email.com");
		doc.setMobile(9876543212l);
		doc.setUserId("Jack");
		doc.setPassword("testUser");
		doc.setCpassword("testUser");
		
		ses.save(doc);
		ses.beginTransaction().commit();*/
		
		/*Doctor doc = (Doctor)ses.get(Doctor.class, 1);
		String hql = "from PatientToDoctor p2d where p2d.doc.id="+doc.getId();
		Query q = ses.createQuery(hql);
		List<PatientToDoctor> docList = q.list();
		for(PatientToDoctor patd : docList) {
			System.out.println(patd.getPat().getFname());
		}*/
		
		//Patient pat = (Patient)ses.get(Patient.class, 1);
	//	List<PatientToDoctor> patdocList = new ArrayList<PatientToDoctor>();
		/*List<PatientToDoctor> patdocList = new ArrayList<PatientToDoctor>();
		
		PatientToDoctor pat2Doc1 = new PatientToDoctor();
		pat2Doc1.setDoc(doc);
		pat2Doc1.setPat(pat);
		
		patdocList.add(pat2Doc1);
		
		pat.setDocList(patdocList);*/
		
		/*for(PatientToDoctor patToDoc : pat.getDocList()) {
			Doctor doc1 = patToDoc.getDoc();
			if(doc1.getId() == doc.getId()) {
				deletedAssignedDoctor(patToDoc);
			}
		}*/
		
		
		/*Patient pat = new Patient();
		pat.setFname("James");
		pat.setLname("Thomos");
		pat.setEmail("james@email.com");
		pat.setMobile(9876543251l);
		pat.setUserId("James");
		pat.setPassword("testUser");
		pat.setCpassword("testUser");
		
		PatientToDoctor pat2Doc1 = new PatientToDoctor();
		pat2Doc1.setDoc(doc);
		pat2Doc1.setPat(pat);
		
		patdocList.add(pat2Doc1);
		
		pat.setDocList(patdocList);
		
		
		ses.save(pat);
		ses.beginTransaction().commit();
		*/
		/**
		 * assiging patient to another doctor
		 */
		/*Patient pat01 = (Patient)ses.get(Patient.class, 1);
		while(pat01.getDocList().size() <=0) {
			pat01.getDocList().add(null);
		}*/
		
		/*for(Doctor assignedDoc : pat01.getDocList()){
			if(assignedDoc.getId() == doc.getId()) {
				//System.out.println(deletedAssignedDoctor(assignedDoc));
				pat01.getDocList().add(null);
			}
		}*/
		//pat01.setDocList(docList);
		/*ses.update(pat01);
		ses.beginTransaction().commit();*/
				
		/*Admin adm = new Admin();
		adm.setFname("ram");
		adm.setLname("test");
		adm.setEmail("ram@email.com");
		adm.setMobile(9876543210l);
		adm.setUserId("ram");
		adm.setPassword("testUser");
		adm.setCpassword("testUser");
		adm.setHosp(hosp);
		
		AdminDao adminDao = new AdminDaoImpl();
		adm = adminDao.addAdmin(adm);
		//Admin adm1 = adminDao.getAdminById(1);
		System.out.println(adminDao.deleteAdmin(2));
		System.out.println(adm);*/
		
		
		
		
	}
}
