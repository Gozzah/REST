/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import facade.Facade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Runes tryllemaskine
 */
public class Tester {
    
    
    public static void main(String[] args) {
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        Facade facade = new Facade(emf);
        
        for (int i = 0; i < facade.getAllPets().size(); i++) {
            
            System.out.println(facade.getAllPets().get(i).getName());
            
        }
        
      
        
    }
}
