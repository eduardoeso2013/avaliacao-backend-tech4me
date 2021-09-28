package br.com.tech4me.venda.view.model;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class VendaRequest {
  @Positive(message = "O codigo do produto dever ser maior que zero")
  @NotEmpty(message = "O codigo não pode ficar em branco")
  @NotBlank(message = "O codigo nao pode conter espaço em branco")
  private Integer codigoProduto;
  @NotEmpty(message = "A data não pode ficar em branco")
  @NotBlank(message = "A data nao pode conter espaço em branco")
  @Size(message = "Tamanho minimo de 8 caracteres")
  private Date data;
  @Positive(message = "O valor não pode ser negativo")
  private Double valor;

  public Integer getCodigoProduto() {
    return codigoProduto;
  }

  public void setCodigoProduto(Integer codigoProduto) {
    this.codigoProduto = codigoProduto;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

}
