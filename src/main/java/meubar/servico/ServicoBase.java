package meubar.servico;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.model.dao.UsuarioDAO;
import meubar.model.dao.BaseDAO;
import meubar.model.entity.BaseEntity;

@Stateless
public abstract class ServicoBase<S extends BaseDAO<T, Long>, T extends BaseEntity<Long>, J> {

	@EJB
	private UsuarioDAO usuarioDAO;

	// This method need to be overrided
	protected abstract S getItemDao();

	// This method need to be overrided
	protected abstract T createItemFromJson(J itemJson);

	// This method need to be overrided
	protected abstract T fillUpdatableFields(T item, J itemJson);

	// This method need to be overrided
	protected abstract J createItemJson(T item);

	public J getById(String id) {
		long lId = Long.parseLong(id);
		T item = (T) getItemDao().findById(lId);
		return createItemJson(item);
	}

	public List<J> getAll() {
		List<T> results = getItemDao().findAll(null);

		List<J> itens = new ArrayList<>();
		for (T item : results) {
			J itemJson = createItemJson(item);
			itens.add(itemJson);
		}
		return itens;

	}

	public T cadastrar(J itemJson) {

		T item = createItemFromJson(itemJson);
		return getItemDao().save(item);

	}

	public boolean deletar(String id) {

		boolean result = false;
		long lId = Long.parseLong(id);
		T item = (T) getItemDao().findById(lId);

		if (item != null) {
			getItemDao().remove(item);
			result = true;
		}
		return result;

	}

	public boolean update(String id, J itemJson) {

		boolean result = false;
		long lId = Long.parseLong(id);
		T item = getItemDao().findById(lId);

		if (item != null) {
			item = fillUpdatableFields(item, itemJson);
			getItemDao().save(item);
			result = true;

		}

		return result;

	}
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}
	
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
}
