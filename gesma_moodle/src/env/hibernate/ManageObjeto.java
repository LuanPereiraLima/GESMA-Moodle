package hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageObjeto {
	 private static SessionFactory factory;
	 
	 public void main() {
		 try{
			 factory = new Configuration().configure("src/env/hibernate/hibernate.cfg.xml").buildSessionFactory();
		 }catch (Throwable ex) {
			 System.err.println("Failed to create sessionFactory object." + ex);
		 throw new ExceptionInInitializerError(ex);
		 }
		 ManageObjeto ME = new ManageObjeto();

		 Integer empID1 = ME.addObjeto("Zara", 1000);
		 Integer empID2 = ME.addObjeto("Daisy", 5000);
		 Integer empID3 = ME.addObjeto("John", 10000);
		 
		 ME.listObjetos();
		 
		ME.updateObjeto(empID1, 5000);
		
		ME.deleteObjeto(empID2);
		 
		ME.listObjetos();
	 }
	 
	 public Integer addObjeto(String nome, int salario){
		 
		 Session session = factory.openSession();
		 Transaction tx = null;
		 Integer id = null;
		 try{
			 tx = session.beginTransaction();
			 ObjTeste objeto = new ObjTeste(nome, salario);
			 id = (Integer) session.save(objeto);
			 tx.commit();
		 }catch (HibernateException e) {
		 if (tx!=null) tx.rollback();
		 	e.printStackTrace();
		 }finally {
			 session.close();
		 }
		 return id;
	 }
	 
	 public void listObjetos(){
		 Session session = factory.openSession();
		 Transaction tx = null;
		 try{
		 tx = session.beginTransaction();
		 List<ObjTeste> objetos = session.createQuery("FROM ObjTeste").list();
		 for (ObjTeste ob : objetos){
			 System.out.println(" First Name: " + ob.getNome());
			 System.out.println(" Salario: " + ob.getSalario());
		 }
		 	tx.commit();
		 }catch (HibernateException e) {
		 if (tx!=null) tx.rollback();
		 	e.printStackTrace();
		 }finally {
			 session.close();
		 }
	 }
	 
	 public void updateObjeto(Integer id, int salario ){
		 Session session = factory.openSession();
		 Transaction tx = null;
		 try{
			tx = session.beginTransaction();
			ObjTeste objeto = (ObjTeste)session.get(ObjTeste.class, id);
			objeto.setSalario(salario);
			session.update(objeto);
			tx.commit();
		 }catch (HibernateException e) {
			 if (tx!=null) tx.rollback();
			 e.printStackTrace();
		 }finally {
			 session.close();
		 }
	 }
	 
	 public void deleteObjeto(Integer id){
		 Session session = factory.openSession();
		 Transaction tx = null;
		 try{
			 tx = session.beginTransaction();
		 	ObjTeste objeto =
			(ObjTeste)session.get(ObjTeste.class, id);
		 	session.delete(objeto);
		 	tx.commit();
		 }catch (HibernateException e) {
			 if (tx!=null) tx.rollback();
		 	e.printStackTrace();
		 }finally {
			 session.close();
		 }
	 }
}
