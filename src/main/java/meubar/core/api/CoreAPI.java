package meubar.core.api;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import meubar.api.impl.BaseAPIImpl;
import meubar.aspects.Permissoes;
import meubar.core.json.pojo.EstadoJson;
import meubar.core.json.pojo.UnidadeJson;
import meubar.core.servico.ServicoCore;
import meubar.estoque.json.pojo.EstoqueControleJson;

import com.google.gson.Gson;

@Path("/core")
@Produces(MediaType.APPLICATION_JSON)
public class CoreAPI extends BaseAPIImpl {

	@EJB
	ServicoCore servicoCore;

	public CoreAPI() {
	}

	@Permissoes(values = { "Administrador" })
	@GET
	@Path("/estados")
	public Response doGetEstados(@CookieParam(value = "auth_token") String token) {

		List<EstadoJson> list = servicoCore.getEstados();
		Gson gson = new Gson();
		String result = gson.toJson(list);
		return Response.status(Status.OK).entity(result).build();

	}

	@Permissoes(values = { "Administrador" })
	@GET
	@Path("/unidades")
	public Response doGetUnidades(@CookieParam(value = "auth_token") String token) {

		List<UnidadeJson> list = servicoCore.getUnidades();
		Gson gson = new Gson();
		String result = gson.toJson(list);
		return Response.status(Status.OK).entity(result).build();

	}

	@Permissoes(values = { "Administrador" })
	@GET
	@Path("/estoque")
	public Response doGetEstoque(@CookieParam(value = "auth_token") String token) {

		List<EstoqueControleJson> list = servicoCore.getEstoque();
		Gson gson = new Gson();
		String result = gson.toJson(list);
		return Response.status(Status.OK).entity(result).build();

	}

	@PermitAll
	@OPTIONS
	public Response doOptions() {

		return Response.status(Status.OK).build();

	}

	@Permissoes(values = { "Administrador" })
	@GET
	public Response doGet(@CookieParam(value = "auth_token") String token) {

		return Response.status(Status.UNAUTHORIZED).build();

	}

	@GET
	@Path("/{id: [0-9]*}")
	public Response doGet(@CookieParam(value = "auth_token") String token, @PathParam("id") String id) {

		return Response.status(Status.UNAUTHORIZED).build();

	}

	@POST
	public Response doPost(@CookieParam(value = "auth_token") String token, String json) {

		return Response.status(Status.UNAUTHORIZED).build();

	}

	@DELETE
	@Path("/{id: [0-9]*}")
	public Response doDelete(@CookieParam(value = "auth_token") String token, @PathParam("id") String id) {

		return Response.status(Status.UNAUTHORIZED).build();

	}

	@PUT
	@Path("/{id: [0-9]*}")
	public Response doPut(@CookieParam(value = "auth_token") String token, @PathParam("id") String id, String json) {

		return Response.status(Status.UNAUTHORIZED).build();

	}
}