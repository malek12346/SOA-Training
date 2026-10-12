package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/ue")
public class UniteEnsRestApi {
    //hi instance  that will help this class
    // to manipulate data : CRUD
    UniteEnseignementBusiness helper= new UniteEnseignementBusiness();
    //get list UEs
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUES (){
        //
        return Response
                .status(200)
                .entity(helper.getListeUE()) // Insert the name from the URL into the response
                .build();
    }
    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createUe(UniteEnseignement unite){
        if (helper.addUniteEnseignement(unite)) {
            return Response.status(201).entity("okay!").build();
        }
        return Response.status(400).entity("error").build();
    }

}
