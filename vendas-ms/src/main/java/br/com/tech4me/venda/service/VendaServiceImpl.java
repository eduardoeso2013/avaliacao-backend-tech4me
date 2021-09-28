package br.com.tech4me.venda.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.venda.model.Venda;
import br.com.tech4me.venda.repository.VendaRepository;
import br.com.tech4me.venda.shared.VendaDto;

@Service
public class VendaServiceImpl implements VendaService {
  @Autowired
  VendaRepository repositorio;

  @Override
  public List<VendaDto> obterTodos() {
    List<Venda> vend = repositorio.findAll();
    return vend.stream().map(p -> new ModelMapper().map(p, VendaDto.class)).collect(Collectors.toList());
  }

  @Override
  public Optional<VendaDto> obterVendaPorId(String id) {
    Optional<Venda> vend = repositorio.findById(id);

    if (vend.isPresent()) {
      return Optional.of(new ModelMapper().map(vend.get(), VendaDto.class));
    }
    return Optional.empty();
  }

  @Override
  public VendaDto cadastrarVenda(VendaDto venda) {
    ModelMapper mapper = new ModelMapper();
    Venda vendaParaSalvar = mapper.map(venda, Venda.class);
    vendaParaSalvar = repositorio.save(vendaParaSalvar);
    return mapper.map(vendaParaSalvar, VendaDto.class);
  }

  @Override
  public void excluirVendaPorId(String id) {
    repositorio.deleteById(id);
  }

  @Override
  public Optional<VendaDto> atualizarVendaPorId(String id, VendaDto venda) {
    ModelMapper mapper = new ModelMapper();
    Optional<Venda> vend = repositorio.findById(id);
    Venda vendaParaSalvar = mapper.map(venda, Venda.class);

    if (vend.isPresent()) {
      // vendaParaSalvar.setId(id);
      vendaParaSalvar = repositorio.save(vendaParaSalvar);
      return Optional.of(mapper.map(vendaParaSalvar, VendaDto.class));
    }
    return Optional.empty();
  }

}
