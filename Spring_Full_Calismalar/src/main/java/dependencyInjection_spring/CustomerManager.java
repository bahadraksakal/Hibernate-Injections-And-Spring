/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencyInjection_spring;

/**
 *
 * @author bahad
 */
public class CustomerManager implements ICustomerService {
    
    private IcutomerDal customerDal;  
    //constructor Injection
    public CustomerManager(IcutomerDal customerDal){
        this.customerDal=customerDal;
    }
    @Override
    public void add(Customer customer){
        // Kurallar  bir sürü  
        //hepsi okeysek
//        depencyInjection_CusotomerDal customerDal = new depencyInjection_CusotomerDal(); bir nesne kendi içinde bir nesneyi new le memeli
                
        customerDal.add(customer);
    }
}
