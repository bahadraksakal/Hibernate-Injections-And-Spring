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
//dal --- data acces layer demektir
public class CusotomerDal implements IcutomerDal{
    
    //her bir firmanın dataBase adresi değiştiğinden bu değişkene xml üzerinden Injection yapılmalı.
    public String connectionString="";

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
    
    @Override
    public void add(Customer customer){
        //... oracle DB. bağlanma kodları
        System.out.print("connectionString: "+this.connectionString+" || ");
        System.out.println("oracle veri tabanına eklendi");
    }
}
