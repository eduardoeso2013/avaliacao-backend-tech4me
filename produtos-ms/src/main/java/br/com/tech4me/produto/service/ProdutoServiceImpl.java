package br.com.tech4me.produto.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.produto.model.Produto;
import br.com.tech4me.produto.repository.ProdutoRepository;
import br.com.tech4me.produto.shared.ProdutoDto;

@Service
public class ProdutoServiceImpl implements ProdutoService {
  @Autowired
  ProdutoRepository repositorio;

  @Override
  public List<ProdutoDto> obterTodos() {
    List<Produto> prod = repositorio.findAll();
    return prod.stream().map(p -> new ModelMapper().map(p, ProdutoDto.class)).collect(Collectors.toList());
  }

  @Override
  public Optional<ProdutoDto> obterProdutoPorId(String id) {
    Optional<Produto> prod = repositorio.findById(id);

    if (prod.isPresent()) {
      return Optional.of(new ModelMapper().map(prod.get(), ProdutoDto.class));
    }
    return Optional.empty();
  }

  @Override
  public ProdutoDto cadastrarProduto(ProdutoDto produto) {
    ModelMapper mapper = new ModelMapper();
    Produto produtoParaSalvar = mapper.map(produto, Produto.class);
    produtoParaSalvar = repositorio.save(produtoParaSalvar);
    return mapper.map(produtoParaSalvar, ProdutoDto.class);
  }

  @Override
  public void excluirProdutoPorId(String id) {
    repositorio.deleteById(id);
  }

  @Override
  public Optional<ProdutoDto> atualizarProdutoPorId(String id, ProdutoDto produto) {
    ModelMapper mapper = new ModelMapper();
    Optional<Produto> prod = repositorio.findById(id);
    Produto produtoParaSalvar = mapper.map(produto, Produto.class);

    if (prod.isPresent()) {
      produtoParaSalvar.setId(id);
      produtoParaSalvar = repositorio.save(produtoParaSalvar);
      return Optional.of(mapper.map(produtoParaSalvar, ProdutoDto.class));
    }
    return Optional.empty();
  }

}
