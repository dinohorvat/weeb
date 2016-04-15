

import Modeli.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateosokac
 */
public class Bazica {
 
    Session session;
    PrintWriter out;
    
    public Bazica(HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();
        this.out = out;
        Configuration cfg = new Configuration();  
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
        SessionFactory factory=cfg.buildSessionFactory();  
        Session session = factory.openSession();  
        this.session = session;   
    }
    
    public void saveNewUser(String name, String lastname, String email,
            String password, String gender, String birthday , String location,
            String phone_num)
    {
        Transaction t = session.beginTransaction();  
        User e1 = new User(name, lastname, email, password,gender,
                birthday,location, phone_num);  
        session.persist(e1);
        t.commit();
        session.close();  

        System.out.println("successfully saved");  
    }
    
    public User getUserByName(String email)
    {
        Query query = session.createQuery("from User where email=:email");
        query.setParameter("email", email);
        List<User> list = query.list();
        if(list.size() == 0)
            return null;
        
        return list.get(0);
    }
}
