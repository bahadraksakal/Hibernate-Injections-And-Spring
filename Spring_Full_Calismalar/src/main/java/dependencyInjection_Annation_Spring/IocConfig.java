/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencyInjection_Annation_Spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author bahad
 */
//xml ile bağımızı tamamen koparacak bir class hazırlıyoruzç
@Configuration
@ComponentScan("dependencyInjection_Annation_Spring")
@PropertySource("classpath:values.properties")
public class IocConfig {
    //XML in aynısı burda da yapılır.
    @Bean
    public ICustomerDal dataBase(){
        return new MySQLCustomerDal();
    }
    @Bean
    public ICustomerService service(){
        return new CustomerManager(dataBase());
    }
}
