/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateAnnation_spring;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory; // J connecttor için olan fabrikayı seçme.
import org.hibernate.cfg.Configuration;



/**
 *
 * @author bahad
 */
public class hibernateMain {
    public static void main(String[] args) {
        // demekki sessionFactory bir implementasyon.
        // session yapıtğımız sql sorgularında bir hata almamız durumda bizi başa döndüren yapılardır
        // örneğin inset ve ardından update yaptık ve update hata aldık. session sayesinde insert işlemide geri alınır.
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(sehirler.class)
                                        .buildSessionFactory();
        
        // hibernate için catchFinal dahil matbu yazım şekli aşağıdadır.
        // session --> Unit Of Work tasarım desenin uygulanmış halidir (design pattern)
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction(); // 
            //  soruglar  inset update delete
//            List<sehirler> sehirlerList= session.createQuery("from sehirler s where s.name LIKE '%ka%' AND (  s.countrycode='TUR' OR s.countrycode='USA' ) ").getResultList(); // veri çekeceğimiz class ismini veriyoruz
             List<sehirler> sehirlerList= session.createQuery("from sehirler s ORDER BY s.name ").getResultList(); // veri çekeceğimiz class ismini veriyoruz
             //  ORDER BY s.name ASC isme göre sırala yap demek. Data base de karışık ASC DEFAULT GELİR -- assending demek yazmaya gerek yok.
            //   ORDER BY s.name DESC  -- ters sıralam yapar.  
            //SQL yazmıyoruz HQL yazıyoruz --> Hibernate query language .
            //'kar%'  karla başlayan , '%kar'  karla biten . '%kar%' içinde kar bulunan.
            // sehirlerlere s diye hitap edeceğimizi söyledik. ve kodu TUR olan şehirleri listele dedik
            //countrycode bizim sehirlerclass ımızdaki string değişkenin ismi bunu yazmamız gerek 
            //fakat bir bu string değişkenini anatosyan ile dataBase ismine bağladık
            //özetle  attiribute isimleri ile data base class isimleri aynı olsun karışmasın yoksa  kafa karışır.
            // türkçe karakterler hatalı basılıyor  daa base e yanlıs cekmisim o sebeple.
            // isminde 'ka' kelimesi bulunan ve türkiyede yada amerikada olan şehirleri ver.
            for (sehirler sehir : sehirlerList) {
                System.out.println(sehir.getName());
            }
            session.getTransaction().commit();  // her şey hatasız commit ile  bunu basıp veri tabanına aktarıyoruz.
            //catch{} kısmını hibernate otomatik yazar normalde catch e session.roll() gibi bir kalıp yazılır geri sar anlamında
        }finally{
            session.close();
        }
        
    }
}
