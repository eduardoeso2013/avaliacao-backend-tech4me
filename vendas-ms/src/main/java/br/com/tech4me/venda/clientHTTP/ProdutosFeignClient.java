package br.com.tech4me.venda.clientHTTP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tech4me.venda.shared.*;

@FeignClient(name = "produtos-ms", fallback = ProdutosFeignClientFallback.class)
public interface ProdutosFeignClient {
  @GetMapping(path = "/api/produtos/{produtos}/lista")
  List<Produto> obterProdutos(@PathVariable String produto);
}

@Component
class ProdutosFeignClientFallback implements ProdutosFeignClient {
  @Override
  public List<Produto> obterProdutos(String dono) {
    return new ArrayList<>();
  }

}
