package com.telusko.HibernateSecondProj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Name name = new Name();
    	name.setfName("Shiwanjalee");
    	name.setmName("Suman");
    	name.setlName("Singh");
    	
    	//  Sector-3/C
    	Address add = new Address();
    	add.setQtrNo(2077);
    	add.setStreet("Uma Nagar");
    	add.setCity("Bokaro Steel City");
    	add.setState("Sector-12D");
    	add.setCountry("India");
    	add.setPostCode(827012);
    	
        Student st = new Student();
        st.setRoll(6);
//        st.setName("Shinuuu");
//        st.setAddress("sector 123");
        st.setName(name);
        st.setAddress(add);
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction txn = session.beginTransaction();
        //session.beginTransaction();
        session.save(st);
        //st = (Student)session.get(Student.class, 1);
        txn.commit();
        //session.getTransaction().commit();
        //System.out.println(st);
    }
}
