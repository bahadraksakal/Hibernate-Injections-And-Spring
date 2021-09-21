/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateAnnation_spring;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author bahad
 */
public class hibernateGruplamaMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(sehirler.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            List<String> countryCodeList= session.createQuery("select s.countrycode from sehirler s GROUP BY s.countrycode ").getResultList(); 
           // 'select s.countrycode'  bu ifade countrycode göre seçim yapar yani bize tekrarlan ifadeleri vermez. Mükerrer yapılar için kullanılabilir.
           //groupby gruplama yapar
            for (String countryCode : countryCodeList) {
                System.out.println(countryCode);
            }
            System.out.println("Toplam Ülke sayısı: "+countryCodeList.size());
            session.getTransaction().commit(); 
        }finally{
            session.close();
        }
    }
}
