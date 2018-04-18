package com.nareshit.utility;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
		
		Doctor doc = (Doctor)ses.get(Doctor.class, 3);
		
		Patient pat = (Patient)ses.get(Patient.class, 1);
		
		/*List<PatientToDoctor> patdocList = new ArrayList<PatientToDoctor>();
		
		PatientToDoctor pat2Doc1 = new PatientToDoctor();
		pat2Doc1.setDoc(doc);
		pat2Doc1.setPat(pat);
		
		patdocList.add(pat2Doc1);
		
		pat.setDocList(patdocList);*/
		
		for(PatientToDoctor patToDoc : pat.getDocList()) {
			Doctor doc1 = patToDoc.getDoc();
			if(doc1.getId() == doc.getId()) {
				deletedAssignedDoctor(patToDoc);
			}
		}
		
		
		/*Patient pat = new Patient();
		pat.setFname("Ram");
		pat.setLname("Nihal");
		pat.setEmail("ram@email.com");
		pat.setMobile(9876543231l);
		pat.setUserId("ram");
		pat.setPassword("testUser");
		pat.setCpassword("testUser");
		
		PatientToDoctor pat2Doc1 = new PatientToDoctor();
		pat2Doc1.setDoc(doc);
		pat2Doc1.setPat(pat);
		
		patdocList.add(pat2Doc1);
		
		pat.setDocList(patdocList);*/
		
		
		/*ses.update(pat);
		ses.beginTransaction().commit();*/
		
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
