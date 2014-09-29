package meubar.estoque.servico;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import meubar.cadastro.model.entity.Usuario;
import meubar.estoque.dao.EstoqueEntradaDAO;
import meubar.estoque.json.pojo.EstoqueEntradaJson;
import meubar.estoque.model.entity.EstoqueEntrada;
import meubar.estoque.model.entity.Fornecedor;
import meubar.estoque.model.entity.Produto;
import meubar.servico.ServicoBase;

@Stateless
public class ServicoEstoqueEntrada extends ServicoBase<EstoqueEntradaDAO, EstoqueEntrada, EstoqueEntradaJson> {

	@EJB
	EstoqueEntradaDAO itemDao;

	public EstoqueEntradaDAO getItemDao() {
		return itemDao;
	}

	@Override
	protected EstoqueEntrada fillUpdatableFields(EstoqueEntrada item, EstoqueEntradaJson itemJson) {
		item.setProduto(new Produto(itemJson.getProdutoId()));
		item.setFornecedor(new Fornecedor(itemJson.getFornecedorId()));
		item.setNotaFiscal(itemJson.getNotaFiscal());

		item.setDataModificacao(new Date());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected EstoqueEntrada createItemFromJson(EstoqueEntradaJson itemJson) {
		EstoqueEntrada item = new EstoqueEntrada();
		item.setProduto(new Produto(itemJson.getProdutoId()));
		item.setFornecedor(new Fornecedor(itemJson.getFornecedorId()));
		item.setNotaFiscal(itemJson.getNotaFiscal());
		item.setDataCriacao(new Date());
		item.setDataModificacao(new Date());
		item.setUsuarioIdCriacao(itemJson.getUsuarioId());
		item.setUsuarioIdModificacao(itemJson.getUsuarioId());
		return item;
	}

	@Override
	protected EstoqueEntradaJson createItemJson(EstoqueEntrada item) {
		EstoqueEntradaJson itemJson = new EstoqueEntradaJson();

		itemJson.setId(item.getId());
		itemJson.setProduto(item.getProduto().getNome());
		itemJson.setProdutoId(item.getProduto().getId());
		itemJson.setFornecedor(item.getFornecedor().getNome());
		itemJson.setFornecedorId(item.getFornecedor().getId());
		itemJson.setNotaFiscal(item.getNotaFiscal());
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
