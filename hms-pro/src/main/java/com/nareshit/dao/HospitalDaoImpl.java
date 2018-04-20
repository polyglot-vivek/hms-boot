package com.nareshit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

import com.nareshit.domain.Hospital;
import com.nareshit.utility.HibernateUtility;

import sun.security.x509.IssuerAlternativeNameExtension;

public class HospitalDaoImpl implements HospitalDao {

	private SessionFactory factory = null;
	private static Session ses = null;
	public Hospital addHospital(Hospital hosp) {
		factory = HibernateUtility.getInstance();
		//Session ses = factory.openSession();
		ses = factory.openSession();
		ses.save(hosp);
		ses.beginTransaction().commit();
		//ses.close();
		return hosp;
	}

	public Hospital getHospitalById(int hospId) {
		factory = HibernateUtility.getInstance();
		Session ses = factory.openSession();
		Hospital hosp = (Hospital)ses.get(Hospital.class, hospId);
		ses.close();
		return hosp;
	}

	public boolean deleteHospital(int hospId) {
		factory = HibernateUtility.getInstance();
		//StatelessSession ses = factory.openStatelessSession();
		Session ses = factory.openSession();
		Hospital hosp = getHospitalById(hospId);
		ses.delete(hosp);
		ses.beginTransaction().commit();
		System.out.println(hosp);
		if(hosp == null)
			return true;
		return false;
	}
	
	
	public List<Hospital>  searchAllHospitals(String hospname,String email, String city){
		StringBuilder sb = new StringBuilder("from Hospital h where ");
		boolean isearched = false;
		if(hospname != null && !hospname.isEmpty()) {
			sb.append("h.hospName like \'%"+hospname+"%\'");
			isearched = true;
		}
		if(email != null && !email.isEmpty()) {
			if(isearched) {
				sb.append("or ");
			}
			sb.append("h.email like \'%"+email+"%\'");
			isearched = true;
		}
		
		if(city != null && !city.isEmpty()) {
			if(isearched) {
				sb.append("or ");
			}
			sb.append("h.city like \'%"+city+"%\'");
			isearched = true;
		}
		
		String hql = sb.toString();
		factory = HibernateUtility.getInstance();
	    ses = factory.openSession();
	    
	    Query q = ses.createQuery(hql);
		
	    List<Hospital> hospList = q.list();
		return hospList;
	}

	public List<Hospital>  getAllHospitalsByPaging(int currPage,int noOfRecPage){
		String hql = "from Hospital h";
	    factory = HibernateUtility.getInstance();
	    ses = factory.openSession();
	    
	    Query q = ses.createQuery(hql);
	    q.setFirstResult((currPage-1)*noOfRecPage);
	    q.setMaxResults(noOfRecPage);
		
		List<Hospital> hospList = q.list();
		return hospList;
	}

}
