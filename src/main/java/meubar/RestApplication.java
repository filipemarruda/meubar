package meubar;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import meubar.api.GrupoAPI;
import meubar.api.autenticacao.AcessoAPI;
import meubar.filters.MeuBarRequestFilter;

@ApplicationPath("/api")
public class RestApplication extends Application{
	
	@Override
	public Set<Class<?>> getClasses(){
		final Set<Class<?>> classes = new HashSet<>();
		classes.add(MeuBarRequestFilter.class);
		classes.add(AcessoAPI.class);
		classes.add(GrupoAPI.class);
		
		return classes;
		
	}

}
