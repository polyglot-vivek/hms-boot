package com.nareshit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.nareshit.domain.Patient;
import com.nareshit.utility.HibernateUtility;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Override
	public Patient savePatient(Patient pat) {
		SessionFactory sf = HibernateUtility.getInstance();
		Session ses = sf.openSession();
		ses.save(pat);
		ses.beginTransaction().commit();
		ses.close();
		return pat;
	}

}
