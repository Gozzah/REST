/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Event;
import entity.Pet;
import facade.Facade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Runes tryllemaskine
 */
@Path("pets")
public class GenericResource {

    @Context
    private UriInfo context;
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
     

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }
    
    

   
    @GET
    @Path("getall")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPetCount() {
        
         EntityManager em = emf.createEntityManager();
         Facade facade = new Facade(emf);
         String result = "Petcount" + facade.getAllPets().size();
         return result;
   
    }
    
        @GET
    @Path("petDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPetDetails() {
         EntityManager em = emf.createEntityManager();
         Facade facade = new Facade(emf);
         List <Pet> petDetails = facade.getAllPets();
          JsonArray jA = new JsonArray();
          
          
            for (int i = 0; i < petDetails.size(); i++) {
                
                 JsonObject jO = new JsonObject();
                 
                 
                 jO.addProperty("ID", petDetails.get(i).getId());
                 jO.addProperty("Name", petDetails.get(i).getName());
                 jO.addProperty("Birth", petDetails.get(i).getBirth());
                 jO.addProperty("Species", petDetails.get(i).getSpecies());
                 jO.addProperty("Owner firstName", petDetails.get(i).getOwnerId().getFirstName());
                 jO.addProperty("Owner LastName", petDetails.get(i).getOwnerId().getLastName());

                 jA.add(jO);
            }
            
            return gson.toJson(jA);
    }
    
    @GET
    @Path("livingPets")
    @Produces(MediaType.APPLICATION_JSON)
    public String alive(){
        
          EntityManager em = emf.createEntityManager();
         Facade facade = new Facade(emf);
         List <Pet> petDetails = facade.getAllPets();
          JsonArray jA = new JsonArray();
        
        for (int i = 0; i < petDetails.size(); i++) {
            
            if (petDetails.get(i).getDeath() == null) {
                   JsonObject jO = new JsonObject();
                 
                 
                 jO.addProperty("ID", petDetails.get(i).getId());
                 jO.addProperty("Name", petDetails.get(i).getName());
                 jO.addProperty("Birth", petDetails.get(i).getBirth());
                 jO.addProperty("Species", petDetails.get(i).getSpecies());
                 jO.addProperty("Owner firstName", petDetails.get(i).getOwnerId().getFirstName());
                 jO.addProperty("Owner LastName", petDetails.get(i).getOwnerId().getLastName());

                 jA.add(jO);
                
                
                
            }
            
            
        }
            return gson.toJson(jA);
    }
    
     @GET
    @Path("{eventdate}")
    @Produces(MediaType.APPLICATION_JSON)
     public String event(@PathParam("eventdate") String event){
         
         EntityManager em = emf.createEntityManager();
         Facade facade = new Facade(emf);
         List <Event> eventDetails = facade.getAllEvents();
          JsonArray jA = new JsonArray();
         
         for (int i = 0; i < eventDetails.size(); i++) {
             
             if (eventDetails.get(i).getDate().equals(event)) {
                 
                     JsonObject jO = new JsonObject();
                 
                 
                 jO.addProperty("ID: ", eventDetails.get(i).getPetId().getId());
            jO.addProperty("Name: ", eventDetails.get(i).getPetId().getName());
            jO.addProperty("Birth: ", eventDetails.get(i).getPetId().getBirth());
            jO.addProperty("Species: ", eventDetails.get(i).getPetId().getSpecies());
            jO.addProperty("Owner FirstName: ", eventDetails.get(i).getPetId().getOwnerId().getFirstName());
            jO.addProperty("Owner LastName: ", eventDetails.get(i).getPetId().getOwnerId().getLastName());
            
            jA.add(jO);
                 
           
                 
             }
         }
             return gson.toJson(jA);
         
         
         
     }
    
    
@Path("addEvent")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addEvent(String content){
        Facade facade = new Facade(emf);
        Event event = gson.fromJson(content, Event.class);
        
        facade.createEvent(event);
        
        return content;
    }
  
}
