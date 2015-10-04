package demo.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CommonDao extends HibernateDaoSupport {
	
	public void save(Serializable obj) {
		try {
			Session s = super.getSessionFactory().openSession();
			s.beginTransaction();
			s.save(obj);
			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
