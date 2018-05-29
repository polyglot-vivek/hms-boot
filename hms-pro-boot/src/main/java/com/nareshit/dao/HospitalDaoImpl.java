package com.nareshit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.domain.Hospital;


@Repository
public class HospitalDaoImpl implements HospitalDao {
	
	@Autowired
	private SessionFactory factory;

	/*public HospitalDaoImpl() {
		// get factory object
		factory = HibernateUtility.getInstance();
	}*/

	// add Hospital
	public Hospital addHospital(Hospital h) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(h);
		tx.commit();
		s.close();
		return h;
	}

	// get all hospitals
	public List<Hospital> getAllHospital() {
		Session s = factory.openSession();
		Criteria crite = s.createCriteria(Hospital.class);
		List<Hospital> l = crite.list();
		s.close();
		return l;
	}

	// get one hospital
	public Hospital getHospitalById(int id) {
		Session s = factory.openSession();
		Hospital h = (Hospital) s.get(Hospital.class, id);
		s.close();
		return h;
	}
	
	public Hospital getHospitalByName(String hospname) {
		Session s = factory.openSession();
		String hql="from Hospital h where h.hospName=:hospital";
		Query q=s.createQuery(hql);
		q.setParameter("hospital", hospname);
		List<Hospital> l=q.list();
		s.close();
		Hospital h =l.get(0);
		return h;
		
	}

	// update data to hospital
	public Hospital updateHospital(Hospital h) {
		Session s = factory.openSession();
		Hospital h1 = (Hospital) s.get(Hospital.class, h.getId());
		BeanUtils.copyProperties(h, h1);
		Transaction tx = s.beginTransaction();
		s.update(h1);
		tx.commit();
		s.close();
		return h1;
	}

	// delete hospital
	public boolean deleteHospital(int id) {
		boolean status;
		Session s = factory.openSession();
		Hospital h = getHospitalById(id);
		Transaction tx = s.beginTransaction();
		s.delete(h);
		tx.commit();
		h=getHospitalById(id);
		if(h==null)
			status= true;
		else
			status= false;
		s.close();
		return status;
	}

	// Search hospital
	public List<Hospital> searchHospital(String hospName, String email, String city, String status) {
		Session s = factory.openSession();
		List<Hospital> l=null;
		Query q=null;
		/*String hql = "from Hospital h where ";
		StringBuilder sb = new StringBuilder(hql);
		String qry = new String(sb);
		boolean isSearched = false;
		if (hospName != null && !hospName.isEmpty()) {
			sb.append("h.hospName like \'%" + hospName + "% \'");
			isSearched = true;
		}
		if (email != null && !email.isEmpty()) {
			if (isSearched) {
				sb.append("or ");
			} else {
				sb.append("h.email like \' %" + email + "% \'");
				isSearched = true;
			}
		}
		if (city != null && !city.isEmpty()) {
			if (isSearched) {
				sb.append("or ");
			} else {
				sb.append("h.city like \' %" + city + "% \'");
				isSearched = true;
			}
		}
		if (status != null && !status.isEmpty()) {
			if (isSearched) {
				sb.append("or ");
			} else {
				sb.append("h.status like \' %" + status + "% \'");
				isSearched = true;
			}
		}*/
		
		if(hospName!=null && hospName!="" || email != null && !email.isEmpty() || city != null && !city.isEmpty() || status != null && !status.isEmpty())
		{
			q = s.createQuery("from Hospital h where h.hospName like '%"+hospName+"%' or h.email like '%"+email+"%' or h.city like '%"+city+"%' or h.status like '%"+status+"%'");
			l = q.list();
		}
		else
		{
			q=s.createQuery("from Hospital h");
			l=q.list();
		}
		return l;
	}
	
	//get Row count
	
	public long getRowCount() {
		Session s = factory.openSession();
		Criteria crite=s.createCriteria(Hospital.class);
		Projection p= Projections.rowCount();
		crite.setProjection(p);
		List l=crite.list();
		long rows=(Long)l.get(0);
		return rows;
	}


	// get record using pagination
	public List<Hospital> getAllHospitalByPaging(int startIndex, int recordperpage) {
		int index;
		if(startIndex<=0)
		{
			index = 1 ;
		}
		else
		{
			index=startIndex;
		}
		Session s = factory.openSession();
		Criteria crite = s.createCriteria(Hospital.class);
		crite.setFirstResult((index-1)*recordperpage);
		crite.setMaxResults(recordperpage);
		List<Hospital> l = crite.list();
		s.close();
		return l;
		
	}

	public boolean activeHospital(int id) {
		boolean status;
		Session s = factory.openSession();
		Hospital h1 = (Hospital) s.get(Hospital.class, id);
		h1.setStatus(true);
		Transaction tx = s.beginTransaction();
		s.update(h1);
		tx.commit();
		h1=(Hospital) s.get(Hospital.class, id);
		status= h1.getStatus();
		s.close();
		return status;
		
	}

	public boolean inactiveHospital(int id) {
		boolean status;
		Session s = factory.openSession();
		Hospital h1 = (Hospital) s.get(Hospital.class, id);
		h1.setStatus(false);
		Transaction tx = s.beginTransaction();
		s.update(h1);
		tx.commit();
		h1=(Hospital) s.get(Hospital.class, id);
		status= h1.getStatus();
		s.close();
		return status;
	}

	
}
