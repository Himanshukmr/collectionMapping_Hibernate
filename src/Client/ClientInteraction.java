package Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Friend;
import utils.HibernateUtil;

public class ClientInteraction {

	public static void main(String[] args) {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		
		 Transaction txn = session.getTransaction();

		try {
			

			 
			 txn.begin();
			 
//			 List<String> l = Arrays.asList("Trini","Kumar");
//			 Set<String> s = new HashSet<>(l);
//			 Friend friend = new Friend("Bard",s);
//			 
//			 session.persist(friend);
			 
			 Friend friend = (Friend)session.get(Friend.class,1l);
			 
			 
			 txn.commit();
			
			
		}
		catch(Exception e) {
			if(txn != null) {
				txn.rollback(); 
			}
			e.printStackTrace();
		}
		finally {
			if(session != null) { 
				session.close();
			}
		}
		
		
	}
}
