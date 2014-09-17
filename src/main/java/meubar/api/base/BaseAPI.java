package meubar.api.base;

import javax.ws.rs.core.Response;

public interface BaseAPI {

	public Response doGet();

	public Response doGet(String id);

	public Response doPost(String json);

	public Response doDelete(String id);

	public Response doPut(String id, String json);
}
