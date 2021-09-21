/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencyInjection_Annation_Spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author bahad
 */
//@Component(value = "dataBase")  sürekli kes yapıştır yapmaktansa bu tanımı config class ın içine alalım.
public class MySQLCustomerDal implements ICustomerDal{
    
    @Value("${SQLDatabaseconnectionString}") //altındaki stringi burrdan oku.
    public String connectionString;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
    
    @Override
    public void add(){
        System.out.print("connectionString: "+this.connectionString+" || ");
        System.out.println("sql veri tabanına customer başarıyla eklendi");
    }
    
}
