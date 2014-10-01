package meubar.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import meubar.business.util.TokenUtils;

import org.apache.commons.lang3.StringUtils;

public class MeuBarResponseFilter implements ContainerResponseFilter {

	private static String X_REQUESTED_HEADER = "X-Requested-With";
	private static String CONTENT_TYPE = "Content-Type";

	public void filter(ContainerRequestContext requestCtx,
			ContainerResponseContext responseCtx) throws IOException {

		String login = (String) requestCtx.getProperty("login");
		String grupo = (String) requestCtx.getProperty("grupo");
		if (!StringUtils.isEmpty(login) && !StringUtils.isEmpty(grupo)) {
			String newToken = TokenUtils.generateToken(login, grupo);
			responseCtx.getHeaders().add(TokenUtils.AUTH_TOKEN, newToken);
		}

		MultivaluedMap<String, Object> rH = responseCtx.getHeaders();
		rH.add("Access-Control-Allow-Origin", "*");
		rH.add("Access-Control-Allow-Credentials", "true");
		rH.add("Access-Control-Allow-Methods",
				"GET, POST, DELETE, PUT, OPTIONS");
		rH.add("Access-Control-Allow-Headers", TokenUtils.AUTH_TOKEN + ", "
				+ X_REQUESTED_HEADER + ", " + CONTENT_TYPE);
		rH.add("Access-Control-Expose-Headers", TokenUtils.AUTH_TOKEN);
		rH.add(CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=UTF-8");
	}
}
