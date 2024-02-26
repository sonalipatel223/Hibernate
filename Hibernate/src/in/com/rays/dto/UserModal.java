package in.com.rays.dto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

public class UserModal {
	public void add(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();

		session.close();

}
	public void update(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.update(dto);

		tx.commit();

		session.close();
}
	public void delete(UserDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(dto);
		tx.commit();
		session.close();
		
	}
	public UserDTO findByPk(int pk) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		UserDTO dto = (UserDTO) session.get(UserDTO.class,1);
		
		session.close();
		
		
		
		return dto;
		
	}
	
	public UserDTO authenticate(String login,String password) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query q =  session.createQuery("from UserDTO where login = ? and pass = ?");
		q.setString(0, login);
		q.setString(1, password);
		List list = q.list();
		UserDTO dto = null;
		if(list.size()>0) {
			dto = (UserDTO) list.get(0);
		}
		session.close();
		return dto;
		
		}
	public List search(UserDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		
			
		List list = criteria.list();
		session.close();
		return list;
		
	}
	
		
		
		
	}
	
