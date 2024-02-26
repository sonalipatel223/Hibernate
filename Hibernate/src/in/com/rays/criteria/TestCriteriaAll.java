package in.com.rays.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import in.com.rays.dto.UserDTO;



public class TestCriteriaAll {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UserDTO.class);
		List list = criteria.list();
		Iterator it = list.iterator();
		while(it.hasNext());
		UserDTO dto = (UserDTO) it.next();
		System.out.print(dto.getId());
		System.out.print("\t" + dto.getFirstName());
		System.out.print("\t" + dto.getLastName());
		System.out.print("\t" + dto.getLogin());
		System.out.print("\t" + dto.getPass());
		System.out.print("\t" + dto.getDob());
		System.out.println("\t" + dto.getAddress());
		
	}

}
