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

    public Financeiro() {

    }

    public int getIdFinanceiro() {
        return idFinanceiro;
    }

    public void setIdFinanceiro(int idFinanceiro) {
        this.idFinanceiro = idFinanceiro;
    }

    public int getVendaIdVenda() {
        return vendaIdVenda;
    }

    public void setVendaIdVenda(int vendaIdVenda) {
        this.vendaIdVenda = vendaIdVenda;
    }

    public Double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(Double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public Double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public Date getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(Date notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public int getCargoIdCargo() {
        return cargoIdCargo;
    }

    public void setCargoIdCargo(int cargoIdCargo) {
        this.cargoIdCargo = cargoIdCargo;
    }

}
