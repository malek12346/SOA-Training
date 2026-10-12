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
    @Path("/{inputCode}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getUEByCode(@PathParam("inputCode")int code){

            return Response.ok(helper.getUEByCode(code)).build();
        }

        @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getUeBySemester(@QueryParam("semestre")int semester){
        return Response.ok(helper.getUEBySemestre(semester)).build();
        }
        @Path("/delete")
    @DELETE
    public Response deleteUeByCode(@QueryParam("code")int code){
        if (helper.deleteUniteEnseignement(code)){
            return Response.status(200).entity("ok").build();
        }
        else return Response.status(400).entity("error").build();
        }
}
