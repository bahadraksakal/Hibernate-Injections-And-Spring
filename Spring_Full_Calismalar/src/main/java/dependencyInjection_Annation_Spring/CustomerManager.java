/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencyInjection_Annation_Spring;

/**
 *
 * @author bahad
 */
public class CustomerManager implements ICustomerService {
    private ICustomerDal customerDal;  
    
    //constructor Injection
    public CustomerManager(ICustomerDal customerDal){
        this.customerDal=customerDal;
    }
    @Override
    public void add(){      
                
        customerDal.add();
    }
}
