package br.com.tech4me.produto.view.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class ProdutoRequest {
  @NotEmpty(message = "O nome não pode ficar em branco")
  private String nome;
  @Positive(message = "O estoque deve ser positivo")
  private Double estoque;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getEstoque() {
    return estoque;
  }

  public void setEstoque(Double estoque) {
    this.estoque = estoque;
  }

}
