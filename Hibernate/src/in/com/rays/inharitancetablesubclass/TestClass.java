package in.com.rays.inharitancetablesubclass;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestClass {
	public static void main(String[] args) {
		/*
		 * Payment p = new Payment(); 
		 * //p.setId(1); p.setAmount(2000);
		 * p.setPaymentType("upi");
		 */
		
		Cheque ch = new Cheque();
		ch.setId(1);
		ch.setAmount(3000);
		ch.setPaymentType("case");
		ch.setChqNumber("12345");
		ch.setBankName("BOI");
		
		CreditCardPayment ccp = new CreditCardPayment();
		ccp.setId(2);
		ccp.setAmount(4000);
		ccp.setCcType("visa");
		ccp.setPaymentType("deposite");
		
		
		
		Cash c = new Cash();
		c.setId(3);
		c.setAmount(5000);
		c.setPaymentType("imps");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(ccp);
		session.save(ch);
		session.save(c);
		
		tx.commit();
		session.close();
		
		
		

		
	}
	

}
