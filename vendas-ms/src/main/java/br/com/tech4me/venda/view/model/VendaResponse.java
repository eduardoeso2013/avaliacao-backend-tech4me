package br.com.tech4me.venda.view.model;

import java.util.Date;

public class VendaResponse {
  private String id;
  private String codigoProduto;
  private Date data;
  private Double valor;

  public String getId() {
    return id;
  }

  public String getCodigoProduto() {
    return codigoProduto;
  }

  public void setCodigoProduto(String codigoProduto) {
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
