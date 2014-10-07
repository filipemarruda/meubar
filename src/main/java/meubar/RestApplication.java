package meubar;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import meubar.acesso.api.AcessoAPI;
import meubar.cadastro.api.GrupoAPI;
import meubar.cadastro.api.UsuarioAPI;
import meubar.core.api.CoreAPI;
import meubar.estoque.api.CategoriaAPI;
import meubar.estoque.api.EstoqueAvulsoAPI;
import meubar.estoque.api.EstoqueEntradaAPI;
import meubar.estoque.api.FornecedorAPI;
import meubar.estoque.api.ProdutoAPI;
import meubar.filters.MeuBarRequestFilter;
import meubar.filters.MeuBarResponseFilter;

@ApplicationPath("/api")
public class RestApplication extends Application{
	
	@Override
	public Set<Class<?>> getClasses(){
		final Set<Class<?>> classes = new HashSet<>();
		classes.add(MeuBarRequestFilter.class);
		classes.add(AcessoAPI.class);
		classes.add(CoreAPI.class);
		classes.add(GrupoAPI.class);
		classes.add(UsuarioAPI.class);
		classes.add(FornecedorAPI.class);
		classes.add(CategoriaAPI.class);
		classes.add(ProdutoAPI.class);
		classes.add(EstoqueEntradaAPI.class);
		classes.add(EstoqueAvulsoAPI.class);
		classes.add(MeuBarResponseFilter.class);
		
		return classes;
		
	}

}
