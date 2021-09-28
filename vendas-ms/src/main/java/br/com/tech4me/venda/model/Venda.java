package br.com.tech4me.venda.model;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Venda {
  @Id
  private String id;
  private Integer codigoProduto;
  private Date data;
  private String dataString;
  private Integer quantidade;
  private Double valor;
  private String produto;

  public Venda() {
  }

  public Venda(Integer codigoProduto, Date data, Integer quantidade, Double valor) {
    this.codigoProduto = codigoProduto;
    this.data = data;
    this.quantidade = quantidade;
    this.valor = valor;
  }

  public Venda(Integer codigoProduto, Date data, Integer quantidade, String produto, Double valor) {
    this.codigoProduto = codigoProduto;
    this.data = data;
    this.quantidade = quantidade;
    this.produto = produto;
    this.valor = valor;
  }

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

  public String getDataFromatted() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String dataFormatted = sdf.format(data);
    return dataFormatted;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

}
