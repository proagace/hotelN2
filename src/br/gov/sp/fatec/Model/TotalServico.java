/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Model;

import java.sql.Date;

/**
 *
 * @author Alexandre
 */
public class TotalServico {
    private int idCadastro, idServico;
    private float total;
    private Date dataSolicitacao;
    private boolean pago;

    public TotalServico(int idCadastro, int idServico, Date dataSolicitacao, boolean pago) {
        this.idCadastro = idCadastro;
        this.idServico = idServico;
        this.dataSolicitacao = dataSolicitacao;
        this.pago = pago;
    }
    

    public TotalServico() {
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }



    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public TotalServico(int idCadastro, float total) {
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
