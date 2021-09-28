package br.com.tech4me.produto.ClientHTTP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tech4me.produto.shared.Venda;

@FeignClient(name = "Vendas", fallback = VendasFeignClientFallback.class)
public interface VendasFeignClient {
  @GetMapping(path = "/api/vendas/{produto}/lista")
  List<Venda> obterVendas(@PathVariable String venda);
}

@Component
class VendasFeignClientFallback implements VendasFeignClient {

  @Override
  public List<Venda> obterVendas(String produto) {
    return new ArrayList<>();
  }
}
