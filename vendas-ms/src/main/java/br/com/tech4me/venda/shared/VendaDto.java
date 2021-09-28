package br.com.tech4me.venda.shared;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class VendaDto {
  private String id;

  @Positive(message = "O codigo deve ser maior que zero")
  private Integer codigoProduto;

  @NotEmpty(message = "A data deve ser preenchida")
  @NotBlank(message = "A data não pode ter apenas espaços em branco")
  @Size(min = 3, message = "A data tem que ter pelo menos 8 caracteres")
  private Date data;
  private String dataString;

  @Positive(message = "A quantidade deve ser maior que zero")
  private Integer quantidade;
  private String produto;

  public String getId() {
    return id;
  }

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

  public String getDataString() {
    return dataString;
  }

  public void setDataString(String dataString) {
    this.dataString = dataString;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public String getProduto() {
    return produto;
  }

  public void setProduto(String produto) {
    this.produto = produto;
  }

}
