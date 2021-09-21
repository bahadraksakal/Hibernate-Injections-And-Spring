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
public class hibernateMainInsert {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(sehirler.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        try {
            session.beginTransaction();
            
            sehirler yeniSehir = new sehirler();
            //ıd oto da
            yeniSehir.setName("Bahox");
            yeniSehir.setCountrycode("BAH");
            yeniSehir.setDistrict("Mars");
            yeniSehir.setPopulation(1);
            
            session.save(yeniSehir);
            System.out.println("Şehir Başarıyla Eklendi");
            // session.save(yeniSehir2); --> işleminde bir hata alırsak bir üstteki işlemde iptal olur
            // bu kural section boyunca sürer.
            
            //UPDATE
            sehirler tempSehir = session.getReference(sehirler.class, 3365); // guncellenecek sehrin id
            System.out.println("update edilecek sehir =  "+tempSehir.getName());
            tempSehir.setPopulation(9999999);
            session.save(tempSehir); // kaydetmeyi asla uutmuyoruz
            System.out.println("Şehir Başarıyla Güncelledi");
            
            //DELETE
            
            tempSehir= session.get(sehirler.class, 4084); // silinecek sehrin id
            session.delete(tempSehir);
            System.out.println("Sehir BASARIYLA SİLİNDİ");
            session.getTransaction().commit();       
            System.out.println("Tüm işlemler başarıyla onaylandı");
        }finally{
            session.close();
        }
    }
}
