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

    /**
     *
     */
    public Venda() {

    }

    /**
     *
     * @return
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     *
     * @param idVenda
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    /**
     *
     * @return
     */
    public int getClienteIdCliente() {
        return clienteIdCliente;
    }

    /**
     *
     * @param clienteIdCliente
     */
    public void setClienteIdCliente(int clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    /**
     *
     * @return
     */
    public Date getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public Date getDataPagamento() {
        return dataPagamento;
    }

    /**
     *
     * @param dataPagamento
     */
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    /**
     *
     * @return
     */
    public Date getDataEnvioProduto() {
        return dataEnvioProduto;
    }

    /**
     *
     * @param dataEnvioProduto
     */
    public void setDataEnvioProduto(Date dataEnvioProduto) {
        this.dataEnvioProduto = dataEnvioProduto;
    }

    /**
     *
     * @return
     */
    public Double getValor() {
        return valor;
    }

    /**
     *
     * @param valor
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     *
     * @return
     */
    public String getTipoPagamento() {
        return tipoPagamento;
    }

    /**
     *
     * @param tipoPagamento
     */
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    /**
     *
     * @return
     */
    public String getDadosCartao() {
        return dadosCartao;
    }

    /**
     *
     * @param dadosCartao
     */
    public void setDadosCartao(String dadosCartao) {
        this.dadosCartao = dadosCartao;
    }

    /**
     *
     * @return
     */
    public int getQtdParcelas() {
        return qtdParcelas;
    }

    /**
     *
     * @param qtdParcelas
     */
    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    /**
     *
     * @return
     */
    public int getFuncionarioIdFuncionario() {
        return funcionarioIdFuncionario;
    }

    /**
     *
     * @param funcionarioIdFuncionario
     */
    public void setFuncionarioIdFuncionario(int funcionarioIdFuncionario) {
        this.funcionarioIdFuncionario = funcionarioIdFuncionario;
    }

    /**
     *
     * @return
     */
    public int getProdutoIdProduto() {
        return produtoIdProduto;
    }

    /**
     *
     * @param produtoIdProduto
     */
    public void setProdutoIdProduto(int produtoIdProduto) {
        this.produtoIdProduto = produtoIdProduto;
    }

    /**
     *
     * @return
     */
    public int getQtdProduto() {
        return qtdProduto;
    }

    /**
     *
     * @param qtdProduto
     */
    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    /**
     *
     * @return
     */
    public int getDesconto() {
        return desconto;
    }

    /**
     *
     * @param desconto
     */
    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    /**
     *
     * @return
     */
    public Double getAcrecimo() {
        return acrecimo;
    }

    /**
     *
     * @param acrecimo
     */
    public void setAcrecimo(Double acrecimo) {
        this.acrecimo = acrecimo;
    }

}
