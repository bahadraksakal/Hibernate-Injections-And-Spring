/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencyInjection_Annation_Spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author bahad
 */
public class Annation_main {
    
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContextAnnation.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
        // context değişirken refreh hatası alırsak context.refresh();
        ICustomerDal customerDal = context.getBean("dataBase",ICustomerDal.class);
        customerDal.add();
        //  tam tekrar
        ICustomerService customerService = context.getBean("service",ICustomerService.class);
        customerService.add(); // bir customermanager ve onun içinde customerDal olusturulur ve custemer dal ğzerinden yazı bastırılırç
        
    }
}
