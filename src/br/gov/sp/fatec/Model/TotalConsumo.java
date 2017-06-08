/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Model;

/**
 *
 * @author Alexandre
 */
public class TotalConsumo {

    private int idCadastro, idProduto, qtdConsumo;
    private float total;
    private boolean pago;

    public TotalConsumo(int idCadastro, int idProduto, int qtdConsumo, boolean pago) {
        this.idCadastro = idCadastro;
        this.idProduto = idProduto;
        this.qtdConsumo = qtdConsumo;
        this.pago = pago;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtdConsumo() {
        return qtdConsumo;
    }

    public void setQtdConsumo(int qtdConsumo) {
        this.qtdConsumo = qtdConsumo;
    }

    public TotalConsumo() {
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public TotalConsumo(int idCadastro, float total) {
        this.idCadastro = idCadastro;
        this.total = total;
    }

    public int getIdCadastro() {
        return idCadastro;
    }

    public void setIdCadastro(int idCadastro) {
        this.idCadastro = idCadastro;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    

}
