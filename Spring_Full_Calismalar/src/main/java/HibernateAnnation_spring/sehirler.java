/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateAnnation_spring;

import javax.persistence.*; // bu seçilir

/**
 *
 * @author bahad
 */

@Entity // bu bir veritabanı nesnesidir demke.
@Table(name = "city") // veritabanında hangi tabloya erişeceğini yazdım.
public class sehirler {
    @Id // zorunlu notasyon
    
    @Column(name = "ID")  // eğer column isimlerini vermez isek değişken ismi ile dataBase arama yapılır.
    private int ID;
    
    @Column(name = "Name")
    private String name;
    
    @Column(name = "CountryCode")    
    private String countrycode;
    
    @Column(name = "District")
    private String district;
    
    @Column(name = "Population")    
    private int population;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    
    
    
}
