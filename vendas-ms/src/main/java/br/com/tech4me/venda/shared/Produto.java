package br.com.tech4me.venda.shared;

public class Produto {
  private String id;
  private String nome;
  private Double valor;
  private int estoque;

  // Construtor padrão sem parametros
  public Produto() {

  }

  // Construtor com um parametro
  public Produto(String id) {
    this.id = id;
  }

  // Construtor com dois parametros
  public Produto(String id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  // Construtor com todos os parametros
  public Produto(String id, String nome, Double valor, int estoque) {
    this.id = id;
    this.nome = nome;
    this.valor = valor;
    this.estoque = estoque;
  }

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

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public int getEstoque() {
    return estoque;
  }

  public void setEstoque(int estoque) {
    this.estoque = estoque;
  }

}
