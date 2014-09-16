package meubar.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import meubar.json.pojo.Messagem;

import com.google.gson.Gson;
 

@Path("resource")
@Produces(MediaType.APPLICATION_JSON)
public class ResourceAPI {

	@Context
    private UriInfo context;
 
    public ResourceAPI() {
    }
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response doUnespectedUse() {
    	
		Messagem msg = new Messagem("Voce e foda");
    	Gson gson = new Gson();
		String result = gson.toJson(msg);
		return Response.status(Status.FORBIDDEN).entity(result).build();

    }
}