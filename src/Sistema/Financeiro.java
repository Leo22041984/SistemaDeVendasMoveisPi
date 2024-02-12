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
public class Financeiro {

    private int idFinanceiro;
    private int vendaIdVenda;
    private Double valorBruto;
    private Double valorLiquido;
    private Date notaFiscal;
    private int cargoIdCargo;

    /**
     *
     */
    public Financeiro() {

    }

    /**
     *
     * @return
     */
    public int getIdFinanceiro() {
        return idFinanceiro;
    }

    /**
     *
     * @param idFinanceiro
     */
    public void setIdFinanceiro(int idFinanceiro) {
        this.idFinanceiro = idFinanceiro;
    }

    /**
     *
     * @return
     */
    public int getVendaIdVenda() {
        return vendaIdVenda;
    }

    /**
     *
     * @param vendaIdVenda
     */
    public void setVendaIdVenda(int vendaIdVenda) {
        this.vendaIdVenda = vendaIdVenda;
    }

    /**
     *
     * @return
     */
    public Double getValorBruto() {
        return valorBruto;
    }

    /**
     *
     * @param valorBruto
     */
    public void setValorBruto(Double valorBruto) {
        this.valorBruto = valorBruto;
    }

    /**
     *
     * @return
     */
    public Double getValorLiquido() {
        return valorLiquido;
    }

    /**
     *
     * @param valorLiquido
     */
    public void setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    /**
     *
     * @return
     */
    public Date getNotaFiscal() {
        return notaFiscal;
    }

    /**
     *
     * @param notaFiscal
     */
    public void setNotaFiscal(Date notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    /**
     *
     * @return
     */
    public int getCargoIdCargo() {
        return cargoIdCargo;
    }

    /**
     *
     * @param cargoIdCargo
     */
    public void setCargoIdCargo(int cargoIdCargo) {
        this.cargoIdCargo = cargoIdCargo;
    }

}
