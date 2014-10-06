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
import meubar.business.exceptions.DBException;
import meubar.estoque.json.pojo.EstoqueEntradaJson;
import meubar.estoque.servico.ServicoEstoqueEntrada;
import meubar.json.pojo.Messagem;

import com.google.gson.Gson;

@Path("/estoqueentradas")
@Produces(MediaType.APPLICATION_JSON)
public class EstoqueEntradaAPI extends BaseAPIImpl {

	@EJB
	ServicoEstoqueEntrada servico;

	public EstoqueEntradaAPI() {
	}

	@PermitAll
	@OPTIONS
	public Response doOptions() {

		return Response.status(Status.OK).build();

	}

	@Permissoes(values = { "Administrador" })
	@GET
	public Response doGet(@CookieParam("auth_token") String token) {

		Status status = Status.NOT_FOUND;
		String result = null;
		Gson gson = new Gson();
		List<EstoqueEntradaJson> list;

		try {

			list = servico.getAll();
			result = gson.toJson(list);
			status = Status.OK;

		} catch (DBException e) {

			status = Status.INTERNAL_SERVER_ERROR;
			Messagem msg = new Messagem(e.getMessage());
			result = gson.toJson(msg);

		}

		return Response.status(status).entity(result).build();

	}


	@Permissoes(values = { "Administrador" })
	@GET
	@Path("/{id: [0-9]*}")
	public Response doGet(@CookieParam("auth_token") String token, @PathParam("id") String id) {

		Status status = Status.NOT_FOUND;
		String result = null;
		Gson gson = new Gson();

		try {

			EstoqueEntradaJson item = servico.getById(id);

			if (item != null) {

				result = gson.toJson(item);
				status = Status.OK;

			}

		} catch (DBException e) {

			status = Status.INTERNAL_SERVER_ERROR;
			Messagem msg = new Messagem(e.getMessage());
			result = gson.toJson(msg);

		}

		return Response.status(status).entity(result).build();

	}

	@Permissoes(values = { "Administrador" })
	@POST
	public Response doPost(@CookieParam("auth_token") String token, String json) {

		Status status = Status.NOT_FOUND;
		String result = null;
		Gson gson = new Gson();

		try {

			EstoqueEntradaJson itemJson = gson.fromJson(json, EstoqueEntradaJson.class);
			itemJson.setUsuarioId(getUsuarioIdFromToken(token));
			servico.cadastrar(itemJson);
			status = Status.ACCEPTED;

		} catch (DBException e) {

			status = Status.INTERNAL_SERVER_ERROR;
			Messagem msg = new Messagem(e.getMessage());
			result = gson.toJson(msg);

		}

		return Response.status(status).entity(result).build();

	}

	@Permissoes(values = { "Administrador" })
	@DELETE
	@Path("/{id: [0-9]*}")
	public Response doDelete(@CookieParam("auth_token") String token, @PathParam("id") String id) {

		Status status = Status.NOT_FOUND;
		String result = null;
		Gson gson = new Gson();

		try {

			boolean deleted = servico.deletar(id);
			if (deleted) {
				status = Status.ACCEPTED;
			}

		} catch (DBException e) {

			status = Status.INTERNAL_SERVER_ERROR;
			Messagem msg = new Messagem(e.getMessage());
			result = gson.toJson(msg);

		}

		return Response.status(status).entity(result).build();

	}

	@Permissoes(values = { "Administrador" })
	@PUT
	@Path("/{id: [0-9]*}")
	public Response doPut(@CookieParam("auth_token") String token, @PathParam("id") String id, String json) {

		Status status = Status.NOT_FOUND;
		String result = null;
		Gson gson = new Gson();

		try {

			boolean updated = false;
			EstoqueEntradaJson itemJson = gson.fromJson(json, EstoqueEntradaJson.class);
			itemJson.setUsuarioId(getUsuarioIdFromToken(token));
			updated = servico.update(id, itemJson);

			if (updated) {

				status = Status.ACCEPTED;

			}

		} catch (DBException e) {

			status = Status.INTERNAL_SERVER_ERROR;
			Messagem msg = new Messagem(e.getMessage());
			result = gson.toJson(msg);

		}

		return Response.status(status).entity(result).build();

	}
}