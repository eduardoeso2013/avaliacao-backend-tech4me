package br.com.tech4me.produto.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.produto.shared.ProdutoDto;

public interface ProdutoService {

  List<ProdutoDto> obterTodos();

  Optional<ProdutoDto> obterProdutoPorId(String id);

  ProdutoDto cadastrarProduto(ProdutoDto produto);

  void excluirProdutoPorId(String id);

  Optional<ProdutoDto> atualizarProdutoPorId(String id, ProdutoDto produto);
}
