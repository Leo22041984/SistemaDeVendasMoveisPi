/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Venda {

    private int idVenda;
    private int clienteIdCliente;
    private Date data;
    private Date dataPagamento;
    private Date dataEnvioProduto;
    private Double valor;
    private String tipoPagamento;
    private String dadosCartao;
    private int qtdParcelas;
    private int funcionarioIdFuncionario;
    private int produtoIdProduto;
    private int qtdProduto;
    private int desconto;
    private Double acrecimo;

    public Venda() {

    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(int clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataEnvioProduto() {
        return dataEnvioProduto;
    }

    public void setDataEnvioProduto(Date dataEnvioProduto) {
        this.dataEnvioProduto = dataEnvioProduto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getDadosCartao() {
        return dadosCartao;
    }

    public void setDadosCartao(String dadosCartao) {
        this.dadosCartao = dadosCartao;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public int getFuncionarioIdFuncionario() {
        return funcionarioIdFuncionario;
    }

    public void setFuncionarioIdFuncionario(int funcionarioIdFuncionario) {
        this.funcionarioIdFuncionario = funcionarioIdFuncionario;
    }

    public int getProdutoIdProduto() {
        return produtoIdProduto;
    }

    public void setProdutoIdProduto(int produtoIdProduto) {
        this.produtoIdProduto = produtoIdProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public Double getAcrecimo() {
        return acrecimo;
    }

    public void setAcrecimo(Double acrecimo) {
        this.acrecimo = acrecimo;
    }

}
