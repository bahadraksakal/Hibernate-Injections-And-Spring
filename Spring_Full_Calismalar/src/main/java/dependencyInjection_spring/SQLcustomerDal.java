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
public class SQLcustomerDal implements IcutomerDal{
     public String connectionString="";

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
    
    @Override
    public void add(Customer customer){
        //my sql ile ilgili bir çok işlem....
        System.out.print("connectionString: "+this.connectionString+" || ");
        System.out.println("sql veri tabanına customer başarıyla eklendi");
    }
            
}
