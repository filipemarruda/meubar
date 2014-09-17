package meubar.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import meubar.api.autenticacao.LoginException;
import meubar.business.TokenUtils;

@Provider
@PreMatching
public class MeuBarRequestFilter implements ContainerRequestFilter {
	@Override
	public void filter( ContainerRequestContext requestCtx ) throws IOException { 

		String path = requestCtx.getUriInfo().getPath();
		
		if (!path.startsWith("/acesso")) {

			String token = requestCtx.getHeaderString("auth_token");
			try {
				TokenUtils.isValidToken(token);
			} catch (LoginException e) {

				requestCtx.abortWith(Response.status(
						Response.Status.UNAUTHORIZED).build());

			}
		}
	}
}
