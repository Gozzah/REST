/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import TEST.DataGenerator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Runes tryllemaskine
 */
@Path("data")
public class Data {

    DataGenerator dG;

    @Context
    private UriInfo context;

    public Data() {

        dG = new DataGenerator();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hest(){
        return "{}";
    }
    @GET
    @Path("{amountOfPeople}/{properties}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("amountOfPeople") int amountOfPeople, @PathParam("properties") String properties, @PathParam("id") int id) {
        return dG.getData(amountOfPeople, properties, id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
