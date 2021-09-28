package br.com.tech4me.venda.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.tech4me.venda.model.Venda;

public interface VendaRepository extends MongoRepository<Venda, String> {

}
