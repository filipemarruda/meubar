package meubar.filters;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import meubar.acesso.exceptions.LoginException;
import meubar.business.util.TokenUtils;

import org.jboss.resteasy.core.ResourceMethodInvoker;

@Provider
public class MeuBarRequestFilter implements ContainerRequestFilter {
	@Override
	public void filter( ContainerRequestContext requestCtx ) throws IOException { 
		ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) requestCtx
				.getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");
		String path = requestCtx.getUriInfo().getPath();
		Method method = methodInvoker.getMethod();
		
		if (!path.startsWith("/acesso")
				&& !method.isAnnotationPresent(PermitAll.class)) {

			Map<String, Cookie> cookies = requestCtx.getCookies();
			Cookie authCookie = cookies.get(TokenUtils.AUTH_TOKEN);
			String token = authCookie.getValue();
			try {
				TokenUtils.isValidToken(token);
				String login = TokenUtils.extractUser(token);
				String grupo = TokenUtils.extractGrupo(token);
				requestCtx.setProperty("login", login);
				requestCtx.setProperty("grupo", grupo);
			} catch (LoginException e) {
				System.out.println("Token Negado:" + token);
				requestCtx.abortWith(Response.status(Response.Status.FORBIDDEN).build());

			}
		}
	}
}
