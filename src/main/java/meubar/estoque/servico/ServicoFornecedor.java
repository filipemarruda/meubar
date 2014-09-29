package meubar.estoque.servico;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.model.entity.Usuario;
import meubar.core.model.entity.Estado;
import meubar.estoque.dao.FornecedorDAO;
import meubar.estoque.json.pojo.FornecedorJson;
import meubar.estoque.model.entity.Fornecedor;
import meubar.servico.ServicoBase;

@Stateless
public class ServicoFornecedor extends ServicoBase<FornecedorDAO, Fornecedor, FornecedorJson> {

	@EJB
	FornecedorDAO itemDao;

	public FornecedorDAO getItemDao() {
		return itemDao;
	}

	@Override
	protected Fornecedor fillUpdatableFields(Fornecedor item, FornecedorJson itemJson) {
		item.setNome(itemJson.getNome());
		item.setCnpj(itemJson.getCnpj());
		item.setEstado(new Estado(itemJson.getEstadoId()));
		item.setCidade(itemJson.getCidade());
		item.setEndereco(itemJson.getEndereco());
		item.setTelefone(itemJson.getTelefone());

		item.setDataModificacao(new Date());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected Fornecedor createItemFromJson(FornecedorJson itemJson) {
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
		return item;
	}

	@Override
	protected FornecedorJson createItemJson(Fornecedor item) {
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
