package com.nareshit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.domain.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private SessionFactory factory;

	/*public AdminDaoImpl() {
		factory = HibernateUtility.getInstance();
	}*/

	public Admin addAdmin(Admin a) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(a);
		tx.commit();
		s.close();
		return a;
	}

	public Admin getAdmin(int adminid) {
		Session s = factory.openSession();
		Admin a = (Admin) s.get(Admin.class, adminid);
		s.close();
		return a;
	}

	public boolean deleteAdmin(int adminid) {
		boolean status;
		Session s = factory.openSession();
		Admin a = getAdmin(adminid);
		Transaction tx = s.beginTransaction();
		s.delete(a);
		tx.commit();
		s.close();
		a=getAdmin(adminid);
		if (a== null)
			status = true;
		else
			status = false;
		
		return status;
	}

	public List<Admin> searchAdmin(String fname, String lname, String email, String mobile) {
		Session s=factory.openSession();
		Query q=null;
		List<Admin> l=null;
		if(fname!=null && fname!="" || lname != null && !lname.isEmpty() || email != null && !email.isEmpty() || mobile != null && !mobile.isEmpty())
		{
			q = s.createQuery("from Admin a where a.fname like '%"+fname+"%' or a.lname like '%"+lname+"%' or a.email like '%"+email+"%' or a.mobile like '%"+mobile+"%'");
			l = q.list();
		}
		else
		{
			q=s.createQuery("from Admin a");
			l=q.list();
		}
		s.close();
		return l;
	}

	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdminByPaging(int startIndex, int recordperpage) {
		
		if(startIndex<=0)
		{
			startIndex=1;
		}
		Session s=factory.openSession();
		Criteria crite=s.createCriteria(Admin.class);
		crite.setFirstResult((startIndex-1)*recordperpage);
		crite.setMaxResults(recordperpage);
		List<Admin> l=crite.list();
		s.close();
		return l;
	}

	public boolean activeAdmin(int adminid) {
		Session s = factory.openSession();
		Admin a = (Admin) s.get(Admin.class, adminid);
		a.setStatus(true);
		Transaction tx=s.beginTransaction();
		s.update(a);
		tx.commit();
		s.close();
		return true;
		
	}

	public boolean inactiveAdmin(int adminid) {
		Session s = factory.openSession();
		Admin a = (Admin) s.get(Admin.class, adminid);
		a.setStatus(false);
		Transaction tx=s.beginTransaction();
		s.update(a);
		tx.commit();
		s.close();
		return false;
	}

	public List<Admin> getAllAdmin() {
			Session s=factory.openSession();
			Criteria crite=s.createCriteria(Admin.class);
			List<Admin> l=crite.list();
			s.close();
			return l;
	}	
	
	public void updateAdmin(Admin a)
	{
		Session s=factory.openSession(); 
		Admin a1=(Admin)s.get(Admin.class, a.getId());
		BeanUtils.copyProperties(a, a1);
		Transaction tx=s.beginTransaction();
		s.update(a1);
		tx.commit();
		s.close();
	}
}
