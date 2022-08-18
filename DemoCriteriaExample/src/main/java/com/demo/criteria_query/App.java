package com.demo.criteria_query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Laptop lap1 = new Laptop();
	   //   lap1.setLid(11);
	      lap1.setLname("Sony");
	      lap1.setPrice(10000);
	      
	      Laptop lap2 = new Laptop();
	   //   lap2.setLid(17);
	      lap2.setLname("Acer");
	      lap2.setPrice(20000);
      
   
	     // std1.setLaptop(lap1);
	      //std2.setLaptop(lap2);
        
       StudentDemo std1 = new StudentDemo(101,"Shubham",98,lap1);
      //  std1.setRollno(101);
        std1.setName("Shubham");
        std1.setMarks(90);
        std1.setLaptop(lap1);
        
        StudentDemo std2 = new StudentDemo(102,"onkar",95,lap2);
       // std2.setRollno(102);
        std2.setName("onkar");
        std2.setMarks(90);
        std2.setLaptop(lap2);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class);
        SessionFactory sf1 = con.buildSessionFactory();
        SessionFactory sf2 = con.buildSessionFactory();
        Session session1 =  sf1.openSession();
        
        // Criteria to fectch Student based on marks equal to 88
        
        Criteria criteria1  = session1.createCriteria(StudentDemo.class);
        criteria1.add(Restrictions.gt("marks", 88));
        List<StudentDemo> results1 = criteria1.list();
        
        // Criteria to fectch Student based on name ---> contains Character 'h'
        
        Criteria criteria2  = session1.createCriteria(StudentDemo.class);
        criteria2.add(Restrictions.ilike("name","%h%"));
        List<StudentDemo> results2 = criteria2.list();
        
        // Criteria to fectch Student based on marks not equal to 85
        Criteria criteria3  = session1.createCriteria(StudentDemo.class);
        criteria3.add(Restrictions.ne("marks", 90));
        List<StudentDemo> results3 = criteria3.list();
        
        // Criteria to fectch Student where name is not null
        
        Criteria criteria4  = session1.createCriteria(StudentDemo.class);
        criteria4.add(Restrictions.isNotNull("name"));
        List<StudentDemo> results4 = criteria4.list();
      
        
        // Criteria with Logical Expression to fectch Student where marks are greter than 88 and Name having character 'h'
        
        LogicalExpression exp = Restrictions.and(Restrictions.gt("marks", 88), Restrictions.ilike("name","%h%"));
        
        Criteria criteria5  = session1.createCriteria(StudentDemo.class);
        criteria5.add(exp);
        List<StudentDemo> results5 = criteria5.list();
        
        //Use of projections 
        
        // Criteria with Projection for row count
        
        Criteria criteria6  = session1.createCriteria(StudentDemo.class);
        criteria6.setProjection(Projections.rowCount());
        List<StudentDemo> results6 = criteria6.list();
    
        // Criteria with Projection for printing max of marks
        
        Criteria criteria7  = session1.createCriteria(StudentDemo.class);
        criteria6.setProjection(Projections.max("marks"));
        List<StudentDemo> results7 = criteria7.list();
       
        // Criteria with Projection for groupProperty -----> like group by clause in DBMS

        Criteria criteria8  = session1.createCriteria(StudentDemo.class);
        criteria6.setProjection(Projections.groupProperty("marks"));
        List<StudentDemo> results8 = criteria8.list();
        
        
        System.out.println("Criteria 1 Example ------------->\n");
        System.out.println(results1);
        System.out.println("Criteria 2 Example ------------->\n");
        System.out.println(results2);
        System.out.println("Criteria 3 Example ------------->\n");
        System.out.println(results3);
        System.out.println("Criteria 4 Example ------------->\n");
        System.out.println(results4);
        
        System.out.println("Criteria 5 Example ------------->\n");
        System.out.println(results5);
        
        System.out.println("Criteria 6 Example With Projections ------------->\n");
        System.out.println(results6);
        
        System.out.println("Criteria 7 Example With Projections ------------->\n");
        System.out.println(results7);
        
        System.out.println("Criteria 8 Example With Projections ------------->\n");
        System.out.println(results8);
        
        session1.close();
        sf1.close();
        System.out.println("Done");
    }																																			
}
