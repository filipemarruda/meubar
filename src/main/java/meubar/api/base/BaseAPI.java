package meubar.api.base;

import javax.ws.rs.core.Response;

public interface BaseAPI {

	public Response doOptions();

	public Response doGet();

	public Response doGet(String id);

	public Response doPost(String json, String Token);

	public Response doDelete(String id);

	public Response doPut(String id, String json, String Token);
}
