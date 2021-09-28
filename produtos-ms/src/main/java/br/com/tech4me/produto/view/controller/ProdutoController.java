package br.com.tech4me.produto.view.controller;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.produto.service.ProdutoService;
import br.com.tech4me.produto.shared.ProdutoDto;
import br.com.tech4me.produto.view.model.ProdutoRequest;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin
public class ProdutoController {
  @Autowired
  private ProdutoService servico;

  @GetMapping
  public ResponseEntity<List<ProdutoDto>> obterProdutos() {
    return new ResponseEntity<>(servico.obterTodos(), HttpStatus.ACCEPTED);
  }

  @GetMapping(value = "/status")
  public String statusServico(@Value("${local.server.port}") String porta) {
    return String.format("Serviço ativo e executando na porta %s", porta);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ProdutoDto> obterProdutoPorId(@PathVariable String id) {
    Optional<ProdutoDto> prod = servico.obterProdutoPorId(id);

    if (prod.isPresent()) {
      return new ResponseEntity<>(prod.get(), HttpStatus.FOUND);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public ResponseEntity<ProdutoDto> cadastrarProduto(@RequestBody @Valid ProdutoDto produto) {
    return new ResponseEntity<>(servico.cadastrarProduto(produto), HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> excluirProduto(@PathVariable String id) {
    servico.excluirProdutoPorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<ProdutoDto> atualizarProduto(@PathVariable String id,
      @RequestBody @Valid ProdutoRequest produto) {
    ProdutoDto dto = new ModelMapper().map(produto, ProdutoDto.class);
    Optional<ProdutoDto> prod = servico.atualizarProdutoPorId(id, dto);

    if (prod.isPresent()) {
      return new ResponseEntity<>(prod.get(), HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
  }

}
