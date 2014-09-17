package meubar.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import meubar.business.TokenUtils;

@Provider
@PreMatching
public class MeuBarResponseFilter implements ContainerResponseFilter {

	public void filter(ContainerRequestContext requestCtx,
			ContainerResponseContext responseCtx) throws IOException {

		responseCtx.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseCtx.getHeaders()
				.add("Access-Control-Allow-Credentials", "true");
		responseCtx.getHeaders().add("Access-Control-Allow-Methods",
				"GET, POST, DELETE, PUT");
		responseCtx.getHeaders().add("Access-Control-Allow-Headers",
				TokenUtils.AUTH_TOKEN);
	}
}
