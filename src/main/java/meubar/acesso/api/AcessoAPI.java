package meubar.acesso.api;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import meubar.acesso.json.pojo.AcessoJson;
import meubar.acesso.json.pojo.TokenJson;
import meubar.api.impl.BaseAPIImpl;
import meubar.business.Messages;
import meubar.business.util.TokenUtils;
import meubar.cadastro.model.entity.Usuario;
import meubar.json.pojo.Messagem;

import com.google.gson.Gson;

@Path("acesso")
@Produces(MediaType.APPLICATION_JSON)
public class AcessoAPI extends BaseAPIImpl {

	@Context
	private UriInfo context;

	public AcessoAPI() {
	}

	@PermitAll
	@OPTIONS
	public Response doOptions() {

		return Response.status(Status.OK).build();

	}

	@GET
	public Response doGet(String token) {

		return Response.status(Status.FORBIDDEN).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response doGet(String token, String id) {

		Messagem msg = new Messagem(Messages.WRONG_FUNCTION_USE);
		Gson gson = new Gson();
		String result = gson.toJson(msg);
		return Response.status(Status.FORBIDDEN).entity(result).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doPost(String json, String token) {

		Object result;
		Gson gson = new Gson();
		AcessoJson acesso = gson.fromJson(json, AcessoJson.class);
		boolean accepted = getServicoAcesso().acesso(acesso.getUser(), acesso.getPass());

		if (accepted) {

			Usuario usuario = getServicoAcesso().findByLogin(acesso.getUser());
			result = new TokenJson(TokenUtils.generateToken(acesso.getUser(), usuario.getGrupo().getNome()),
					Long.toString(usuario.getId()), usuario.getNome(), usuario.getGrupo().getNome());

		} else {

			return Response.status(Status.FORBIDDEN).build();

		}

		String jsonReturn = gson.toJson(result);
		return Response.status(Status.ACCEPTED).entity(jsonReturn).build();

	}

	@DELETE
	public Response doDelete(String token, String id) {

		return Response.status(Status.FORBIDDEN).build();

	}

	@PUT
	public Response doPut(String token, String id, String json) {

		return Response.status(Status.FORBIDDEN).build();

	}

}