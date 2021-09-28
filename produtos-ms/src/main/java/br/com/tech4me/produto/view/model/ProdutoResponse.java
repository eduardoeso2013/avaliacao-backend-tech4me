package br.com.tech4me.produto.view.model;

public class ProdutoResponse {
  private String id;
  private String nome;
  private Double estoque;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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
