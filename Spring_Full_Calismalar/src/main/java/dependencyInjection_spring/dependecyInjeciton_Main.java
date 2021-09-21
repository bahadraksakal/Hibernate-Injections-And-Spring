/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencyInjection_spring;

import java.io.FileNotFoundException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author bahad
 */
public class dependecyInjeciton_Main {
    // IoC - Inversion of Control bu yapıyı ayağa kaldıran tasarım desenin adı :  // Dependecy Injection -- desing pattern
    public static void main(String[] args) throws FileNotFoundException{
        CustomerManager customerManager = new CustomerManager(new CusotomerDal());
        //IcustomerDal ı implemente eden CustomerDal'i oracle veri tabanı için oluşturup yolladık daha sonra.     
        System.out.println("\n--dependency Injection tasarım kalıbının hazırlanması--\n");
        customerManager.add(new Customer());
        // mySql veri tabanı için
        customerManager= new  CustomerManager(new SQLcustomerDal());
        //yine IcustomerDal ı implemente eden SQLCustomerDal'i SQL veri tabanı için oluşturup yolladık daha sonra. 
        customerManager.add(new Customer());
        // burda yaptığımız tüm süreç bizim için spring in IoC alt yapısı ile arka planda yapıcak
        //spring ile yapmak
        //file:D:\Belgeler\NetBeansProjects\Spring_Full_Calismalar\src\main\java\values.properties file tagı ile dosya yolu verme
        ClassPathXmlApplicationContext contex = new ClassPathXmlApplicationContext("appContext.xml");
        customerManager= new  CustomerManager(contex.getBean("dataBase",IcutomerDal.class));
         System.out.println("\n--xml üzerinden nesne new lemek--\n");
        customerManager.add(new Customer()); // sql yazmasını bekleriz. çünkü contexte sql yönlendirdim
        //customerManger i springe new letmek
        ICustomerService iCustomerService =contex.getBean("service",ICustomerService.class);
        //constu bi database istiyor ondan dolayı xml de bağımlıklık tanımlanmalı
        System.out.println("\n--bağımlı contructor ve xml  contructor args--\n");
        iCustomerService.add(new Customer());
    }
}
