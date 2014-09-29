package meubar.estoque.api;

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
import meubar.estoque.json.pojo.EstoqueEntradaJson;
import meubar.estoque.servico.ServicoEstoqueEntrada;
import meubar.json.pojo.Messagem;

import com.google.gson.Gson;
 

@Path("/estoqueentradas")
@Produces(MediaType.APPLICATION_JSON)
public class EstoqueEntradaAPI extends BaseAPIImpl {

	@EJB
	ServicoEstoqueEntrada servicoEstoqueEntrada;
 
    public EstoqueEntradaAPI() {
    }

	@PermitAll
	@OPTIONS
	public Response doOptions() {
		return Response.status(Status.OK).build();
	};

	@Permissoes(values = { "Administrador" })
	@GET
	public Response doGet(@CookieParam("auth_token") String token) {
		List<EstoqueEntradaJson> list = servicoEstoqueEntrada.getAll();
		Gson gson = new Gson();
		String result = gson.toJson(list);
		return Response.status(Status.OK).entity(result).build();
	}

	@Permissoes(values = { "Administrador" })
	@GET
	@Path("/{id: [0-9]*}")
	public Response doGet(@CookieParam("auth_token") String token,
			@PathParam("id") String id) {
		EstoqueEntradaJson item = servicoEstoqueEntrada.getById(id);
		Gson gson = new Gson();
		String result = gson.toJson(item);
		return Response.status(Status.OK).entity(result).build();
	}

	@Permissoes(values = { "Administrador" })
	@POST
	public Response doPost(@CookieParam("auth_token") String token, String json) {
		Object result;
		Gson gson = new Gson();
		
		try {

			EstoqueEntradaJson itemJson = gson.fromJson(json, EstoqueEntradaJson.class);
			itemJson.setUsuarioId(getUsuarioIdFromToken(token));
			result = servicoEstoqueEntrada.cadastrar(itemJson);

		} catch (Exception e) {
			result = new Messagem(e.getMessage());
		}
		
		return Response.status(Status.ACCEPTED).entity(result).build();
	}

	@Permissoes(values = { "Administrador" })
	@DELETE
	@Path("/{id: [0-9]*}")
	public Response doDelete(@CookieParam("auth_token") String token,
			@PathParam("id") String id) {

		Status result = Status.NOT_FOUND;
		boolean deleted = servicoEstoqueEntrada.deletar(id);
		if (deleted) {
			result = Status.ACCEPTED;
		}

		return Response.status(result).build();
	}

	@Permissoes(values = { "Administrador" })
	@PUT
	@Path("/{id: [0-9]*}")
	public Response doPut(@CookieParam("auth_token") String token,
			@PathParam("id") String id, String json) {
		Object resultObj = null;
		Status result = Status.NOT_FOUND;
		boolean updated = false;
		Gson gson = new Gson();

		try {

			EstoqueEntradaJson itemJson = gson.fromJson(json, EstoqueEntradaJson.class);
			itemJson.setUsuarioId(getUsuarioIdFromToken(token));
			updated = servicoEstoqueEntrada.update(id, itemJson);

		} catch (Exception e) {
			resultObj = new Messagem(e.getMessage());
		}

		if (updated) {
			result = Status.ACCEPTED;
		}

		return Response.status(result).entity(resultObj).build();
	}
}