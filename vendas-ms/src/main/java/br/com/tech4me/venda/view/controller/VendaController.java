package br.com.tech4me.venda.view.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.tech4me.venda.service.VendaService;
import br.com.tech4me.venda.shared.VendaDto;
import br.com.tech4me.venda.view.model.VendaRequest;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/pessoas")
@CrossOrigin
public class VendaController {
  @Autowired
  VendaService servico;

  @GetMapping
  public ResponseEntity<List<VendaDto>> obterVendas() {
    return new ResponseEntity<>(servico.obterTodos(), HttpStatus.ACCEPTED);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<VendaDto> obterVendaPorId(@PathVariable String id) {
    Optional<VendaDto> pess = servico.obterVendaPorId(id);

    if (pess.isPresent()) {
      return new ResponseEntity<>(pess.get(), HttpStatus.FOUND);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

  }

  @PostMapping
  public ResponseEntity<VendaDto> cadastrarVenda(@RequestBody @Valid VendaDto pessoa) {
    return new ResponseEntity<>(servico.cadastrarVenda(pessoa), HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> excluirVenda(@PathVariable String id) {
    servico.excluirVendaPorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<VendaDto> atualizarVenda(@PathVariable String id, @RequestBody @Valid VendaRequest pessoa) {
    VendaDto dto = new ModelMapper().map(pessoa, VendaDto.class);
    Optional<VendaDto> pess = servico.atualizarVendaPorId(id, dto);

    if (pess.isPresent()) {
      return new ResponseEntity<>(pess.get(), HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
  }
}