package rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Runes tryllemaskine
 */

@Path("randomuuid")
public class UuidResource
{
    @Context
    private UriInfo context;

    @Context
    HttpHeaders headers;

    public UuidResource()
    {
    }

    
    @GET
    public String generateUUID()
    {
        return "{\"uuid\":\"" +UUID.randomUUID().toString() + "\"}";
    }

    @GET
    @Path("{timestamp}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTimeStamp(@PathParam("timestamp") int arg)
    {

        if(arg == 1){
             return "{\"uuid\":\"" +UUID.randomUUID().toString() + "\",\"created\":\""+ new SimpleDateFormat("dd.MM.yyyy-HH.mm.ss").format(new Date()) + "\"   ";
        }else if(arg == 0){
            return "{\"uuid\":\"" +UUID.randomUUID().toString() + "\"}";
        }
        return "{Værdien skal være 0 eller 1}";
    }
    
   
    @GET
    @Path("{timestamp}/{count}")

    @Produces(MediaType.APPLICATION_JSON)
    public String getTimeStampAndCount(@PathParam("timestamp") int arg, @PathParam("count") int arg2)
    { 
        String date ="";
     
               
               List<String> tempList = new ArrayList<String>();
                
                for (int i = 0; i < arg2; i++)
                {
                   
                    tempList.add(UUID.randomUUID().toString()) ;
                }
            
        
           return tempList.toString();
                
                
            }
            
    }
                
    
