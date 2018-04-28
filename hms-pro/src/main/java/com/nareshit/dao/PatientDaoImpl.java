package com.nareshit.dao;

import org.hibernate.Query;
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

	@Override
	public boolean isPatientExisted(String userId) {
		boolean isPatExisted = false;
		SessionFactory sf = HibernateUtility.getInstance();
		Session ses = sf.openSession();
		String hql = "from Patient pat where pat.userId=:userId";
		Query q = ses.createQuery(hql);
		q.setParameter("userId", userId);
		Patient pat = (Patient) q.uniqueResult();
		if(pat != null) {
			isPatExisted = true;
		}
		ses.close();
		return isPatExisted;
	}
	
	@Override
	public Patient getPatientByUserId(String userId) {
		SessionFactory sf = HibernateUtility.getInstance();
		Session ses = sf.openSession();
		String hql = "from Patient pat where pat.userId=:userId";
		Query q = ses.createQuery(hql);
		q.setParameter("userId", userId);
		Patient pat = (Patient) q.uniqueResult();
		ses.close();
		return pat;
	}

	@Override
	public boolean activateUser(String userId) {
		boolean isUserActivated = false;
		SessionFactory sf = HibernateUtility.getInstance();
		Session ses = sf.openSession();
        Patient pat = getPatientByUserId(userId);
        pat.setActive(true);
        ses.update(pat);
        ses.beginTransaction().commit();
        if(pat.isActive()) {
        	isUserActivated = true;
        }
        ses.close();
        return isUserActivated;
	}

}
