package meubar.api.base;

import javax.ws.rs.core.Response;

public interface BaseAPI {

	public Response doOptions();

	public Response doGet(String token);

	public Response doGet(String token, String id);

	public Response doPost(String token, String json);

	public Response doDelete(String token, String id);

	public Response doPut(String token, String id, String json);
}
