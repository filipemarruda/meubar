package meubar.estoque.servico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.model.entity.Usuario;
import meubar.core.model.entity.Estado;
import meubar.estoque.dao.FornecedorDAO;
import meubar.estoque.json.pojo.FornecedorJson;
import meubar.estoque.model.entity.Fornecedor;
import meubar.servico.ServicoBase;

@Stateless
public class ServicoFornecedor extends ServicoBase {

	@EJB
	private FornecedorDAO fornecedorDAO;

	public FornecedorJson getById(String id) {
		long lId = Long.parseLong(id);
		Fornecedor item = fornecedorDAO.findById(lId);
		return createFornecedorJson(item);
	}

	public List<FornecedorJson> getAll() {
		List<Fornecedor> results = fornecedorDAO.findAll(null);

		List<FornecedorJson> itens = new ArrayList<>();
		for (Fornecedor item : results) {
			FornecedorJson itemJson = createFornecedorJson(item);
			itens.add(itemJson);
		}
		return itens;

	}

	public Fornecedor cadastrar(FornecedorJson itemJson) {

		Fornecedor item = new Fornecedor();
		item.setNome(itemJson.getNome());
		item.setCnpj(itemJson.getCnpj());
		item.setEstado(new Estado(itemJson.getEstadoId()));
		item.setCidade(itemJson.getCidade());
		item.setEndereco(itemJson.getEndereco());
		item.setTelefone(itemJson.getTelefone());
		item.setDataCriacao(new Date());
		item.setDataModificacao(new Date());
		item.setUsuarioIdCriacao(itemJson.getUsuarioId());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return fornecedorDAO.save(item);


	}

	public boolean deletar(String id) {

		boolean result = false;
		long lId = Long.parseLong(id);
		Fornecedor item = fornecedorDAO.findById(lId);

		if (item != null) {
			fornecedorDAO.remove(item);
			result = true;
		}
		return result;

	}

	public boolean update(String id, FornecedorJson itemJson) {

		boolean result = false;
		long lId = Long.parseLong(id);
		Fornecedor item = fornecedorDAO.findById(lId);

		if (item != null) {

			item.setNome(itemJson.getNome());
			item.setCnpj(itemJson.getCnpj());
			item.setEstado(new Estado(itemJson.getEstadoId()));
			item.setCidade(itemJson.getCidade());
			item.setEndereco(itemJson.getEndereco());
			item.setTelefone(itemJson.getTelefone());

			item.setDataModificacao(new Date());
			item.setUsuarioIdModificacao(itemJson.getUsuarioId());
			fornecedorDAO.save(item);
			result = true;

		}

		return result;

	}

	private FornecedorJson createFornecedorJson(Fornecedor item) {
		FornecedorJson itemJson = new FornecedorJson();

		itemJson.setId(item.getId());
		itemJson.setNome(item.getNome());
		itemJson.setCnpj(item.getCnpj());
		itemJson.setEstadoId(item.getEstado().getId());
		itemJson.setUf(item.getEstado().getUf());
		itemJson.setCidade(item.getCidade());
		itemJson.setEndereco(item.getEndereco());
		itemJson.setTelefone(item.getTelefone());
		itemJson.setDataCriacao(item.getDataCriacao());
		itemJson.setDataModificacao(item.getDataModificacao());
		Usuario usuarioCriacao = getUsuarioDAO().findById(item
				.getUsuarioIdCriacao());
		Usuario usuarioModificacao = getUsuarioDAO().findById(item
				.getUsuarioIdModificacao());
		itemJson.setUsuarioCriacao(usuarioCriacao.getNome());
		itemJson.setUsuarioModificacao(usuarioModificacao.getNome());

		return itemJson;
	}
}
