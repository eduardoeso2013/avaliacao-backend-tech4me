package br.com.tech4me.produto.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ProdutoDto {

  private String id;

  @NotEmpty(message = "O nome deve ser preenchido")
  @NotBlank(message = "O nome não pode ter espaço em branco")
  @Size(min = 3, message = "O nome deve conter pelo menos 3 caracteres")
  private String nome;

  @NotEmpty(message = "O valor deve ser preenchido")
  @NotBlank(message = "O valor não pode ter espaço em branco")
  @Positive(message = "O valor não pode ser negativo")
  private Double valor;

  @NotEmpty(message = "O estoque não deve ser preenchido")
  @NotBlank(message = "O estoque não pode ter espaço em branco")
  @Positive(message = "O estoque não pode ser negativo")
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

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Double getEstoque() {
    return estoque;
  }

  public void setEstoque(Double estoque) {
    this.estoque = estoque;
  }

}
