/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Quote;
import exception.QuoteNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Peter Riis
 */
@Path("quote")
public class QuoteResource {
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    private static Map<Integer,String> quotes = new HashMap() {
  {
   put(1, "Friends are kisses blown to us by angels");
   put(2, "Do not take life too seriously. You will never get out of it alive");
   put(3, "Behind every great man, is a woman rolling her eyes");
   }
};

    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of QuoteResource
     */
    public QuoteResource(){
    }

  
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuote(@PathParam("id") int id) throws QuoteNotFoundException{
        
        if(quotes.size() == 0)
        {
            throw new QuoteNotFoundException("No Quotes Created Yet");
        }
        if(id >= quotes.size())
        {
            throw new QuoteNotFoundException("Quote with requested id not found");
        }
        
        return quotes.get(id);
    }
    
    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomQuote() throws QuoteNotFoundException{
        
                if(quotes.size() == 0)
        {
            throw new QuoteNotFoundException("No Quotes Created Yet");
        }
        
        int id = (new Random().nextInt(quotes.size())+1);
        Quote q = new Quote(id, quotes.get(id));
        String result = gson.toJson(q);
        return result;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postData(String content) throws QuoteNotFoundException{
        
   
        
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        String quote = "";
        
        if(body.has("text")){
            quote = body.get("text").getAsString();
        }
        int newId = quotes.size()+1;
        
        Quote q = new Quote(newId,quote);
        
        if(!body.has("text")){
            throw new QuoteNotFoundException("code\": 500, \"message\": \"Internal server Error, we are very sorry for the inconvenience");
        }
        
        quotes.put(newId, quote);
        return gson.toJson(q);
    }
    
    /**
     * PUT method for updating or creating an instance of QuoteResource
     * @param content representation for the resource
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateQuote(String content, @PathParam("id") int id) throws QuoteNotFoundException{
        
                if(quotes.size() == 0)
        {
            throw new QuoteNotFoundException("No Quotes Created Yet");
        }
        if(id >= quotes.size())
        {
            throw new QuoteNotFoundException("Quote with requested id not found");
        }
        
        Quote newQuote = gson.fromJson(content, Quote.class);
        newQuote.setId(id);
        quotes.put(id, newQuote.getQuote());
        return gson.toJson(newQuote);
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteQuote(@PathParam("id") int id) throws QuoteNotFoundException{      
        
                if(quotes.size() == 0)
        {
            throw new QuoteNotFoundException("No Quotes Created Yet");
        }
        if(id >= quotes.size())
        {
            throw new QuoteNotFoundException("Quote with requested id not found");
        }
        
        Quote oldQuote = new Quote();
        oldQuote.setQuote(quotes.get(id));
        quotes.remove(id);
        return gson.toJson(oldQuote);
    }
}
