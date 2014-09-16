package meubar.api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import meubar.business.Messages;
import meubar.business.TokenUtils;
import meubar.cadastro.json.pojo.Acesso;
import meubar.cadastro.json.pojo.Token;
import meubar.cadastro.servico.ServicoCadastro;
import meubar.json.pojo.Messagem;

import com.google.gson.Gson;
 

@Path("acesso")
@Produces(MediaType.APPLICATION_JSON)
public class AcessoAPI {

	@EJB
	ServicoCadastro servicoCadastro;

	@Context
    private UriInfo context;
 
    public AcessoAPI() {
    }
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response doUnespectedUse() {

    	
		Messagem msg = new Messagem(Messages.WRONG_FUNCTION_USE);
    	Gson gson = new Gson();
		String result = gson.toJson(msg);
		return Response.status(Status.FORBIDDEN).entity(result).build();

    }
    
    @POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response doAuth(String json) {

		Object result;
		Gson gson = new Gson();

		try {
			Acesso acesso = gson.fromJson(json, Acesso.class);

			boolean accepted = servicoCadastro.acesso(acesso.getUser(),
				acesso.getPass());

			if (accepted) {

				result = new Token(TokenUtils.generateToken(acesso.getUser()));

			} else {
				result = new Messagem(Messages.WRONG_USER_OR_PASS_DESC);
			}

		} catch (Exception e) {
			result = new Messagem(e.getMessage());
		}

		String jsonReturn = gson.toJson(result);

		return Response.status(Status.OK).entity(jsonReturn).build();

    }
}