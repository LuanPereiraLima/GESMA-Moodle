package hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageCurso {
	 private static SessionFactory factory;
	 
	 public void main() {
		try{
			 factory = new Configuration().configure("src/env/hibernate/hibernate.cfg.xml").buildSessionFactory();
		}catch (Throwable ex) {
			 System.err.println("Failed to create sessionFactory object." + ex);
			 throw new ExceptionInInitializerError(ex);
		}
		ManageCurso ME = new ManageCurso();
		//ME.listObjetos();
	 }
	 
	 public void listarCursosMaioresQueOTimePassado(long time){
		 Session session = factory.openSession();
		 Transaction tx = null;
		 try{
		 
			 tx = session.beginTransaction();
		 
			 Query query = session.createQuery("FROM Curso where timecreated > :time");
			 query.setParameter("time", time);
			 List<Curso> objetos = query.list();
		
			 for (Curso ob : objetos){
				 System.out.println(" Id: " + ob.getId());
				 System.out.println(" IdNumber: " + ob.getIdNumber());
				 System.out.println(" FullName: " + ob.getFullName());
				 System.out.println(" TimeCreated: " + ob.getTimeCreated());
			 }
			 
		 	tx.commit();
		 }catch (HibernateException e) {
			 if (tx!=null) tx.rollback();
			 	e.printStackTrace();
		 }finally {
			 session.close();
		 }
	 }
}
