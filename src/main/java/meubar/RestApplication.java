package meubar;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import meubar.api.AcessoAPI;
import meubar.api.ResourceAPI;

@ApplicationPath("/api")
public class RestApplication extends Application{
	
	@Override
	public Set<Class<?>> getClasses(){
		final Set<Class<?>> classes = new HashSet<>();
		classes.add(AuthenticatorFilter.class);
		classes.add(AcessoAPI.class);
		classes.add(ResourceAPI.class);
		
		return classes;
		
	}

}
