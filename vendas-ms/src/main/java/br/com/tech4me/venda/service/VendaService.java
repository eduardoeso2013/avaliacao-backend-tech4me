package br.com.tech4me.venda.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.venda.shared.VendaDto;

public interface VendaService {
  List<VendaDto> obterTodos();

  Optional<VendaDto> obterVendaPorId(String id);

  VendaDto cadastrarVenda(VendaDto venda);

  void excluirVendaPorId(String id);

  Optional<VendaDto> atualizarVendaPorId(String id, VendaDto venda);

}
