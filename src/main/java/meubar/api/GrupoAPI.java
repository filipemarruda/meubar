package meubar.api;

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

import meubar.api.base.BaseAPIImpl;
import meubar.cadastro.json.pojo.GrupoJson;
import meubar.cadastro.servico.ServicoGrupo;
import meubar.json.pojo.Messagem;

import com.google.gson.Gson;
 

@Path("/grupos")
@Produces(MediaType.APPLICATION_JSON)
public class GrupoAPI extends BaseAPIImpl {

	@EJB
	ServicoGrupo servicoGrupo;
 
    public GrupoAPI() {
    }

	@PermitAll
	@OPTIONS
	public Response doOptions() {
		return Response.status(Status.OK).build();
	};

	@GET
	public Response doGet() {
		List<GrupoJson> list = servicoGrupo.getAll();
		Gson gson = new Gson();
		String result = gson.toJson(list);
		return Response.status(Status.OK).entity(result).build();
	}

	@GET
	@Path("/{id: [0-9]*}")
	public Response doGet(@PathParam("id") String id) {
		GrupoJson grupo = servicoGrupo.getById(id);
		Gson gson = new Gson();
		String result = gson.toJson(grupo);
		return Response.status(Status.OK).entity(result).build();
	}

	@POST
	public Response doPost(String json,
			@CookieParam(value = "auth_token") String token) {
		Object result;
		Gson gson = new Gson();

		try {

			GrupoJson grupoJson = gson.fromJson(json, GrupoJson.class);
			grupoJson.setUsuarioId(getUsuarioIdFromToken(token));
			result = servicoGrupo.cadastrar(grupoJson);

		} catch (Exception e) {
			result = new Messagem(e.getMessage());
		}
		
		return Response.status(Status.ACCEPTED).entity(result).build();
	}

	@DELETE
	@Path("/{id: [0-9]*}")
	public Response doDelete(@PathParam("id") String id) {

		Status result = Status.NOT_FOUND;
		boolean deleted = servicoGrupo.deletar(id);
		if (deleted) {
			result = Status.ACCEPTED;
		}

		return Response.status(result).build();
	}

	@PUT
	@Path("/{id: [0-9]*}")
	public Response doPut(@PathParam("id") String id, String json,
			@CookieParam(value = "auth_token") String token) {
		Object resultObj = null;
		Status result = Status.NOT_FOUND;
		boolean updated = false;
		Gson gson = new Gson();

		try {

			GrupoJson grupoJson = gson.fromJson(json, GrupoJson.class);
			grupoJson.setUsuarioId(getUsuarioIdFromToken(token));
			updated = servicoGrupo.update(id, grupoJson);

		} catch (Exception e) {
			resultObj = new Messagem(e.getMessage());
		}

		if (updated) {
			result = Status.ACCEPTED;
		}

		return Response.status(result).entity(resultObj).build();
	}
}