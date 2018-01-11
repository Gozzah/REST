/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Event;
import entity.Pet;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Runes tryllemaskine
 */
public class Facade {
    
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU",null);

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    
}
    
    public List <Pet> getAllPets(){
        
    EntityManager em = getEntityManager();
        
        TypedQuery<Pet> query =
        em.createNamedQuery("Pet.findAll",Pet.class);
        List<Pet> result = query.getResultList();
        return result;  
    }
    
     public List <Event> getAllEvents(){
        
    EntityManager em = getEntityManager();
        
        TypedQuery<Event> query =
        em.createNamedQuery("Event.findAll",Event.class);
        List<Event> result = query.getResultList();
        return result;  
    }
    
  public void createEvent(Event event){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();
        em.close();
    }
     
    
    
        public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
