/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Model;

import java.util.Date;

/**
 *
 * @author Thiago
 */
public class Diarias {
    private int idLocacao;
    private Date criacao, atualizacao;
    private float total;
    private boolean pago;

    public Diarias(int idLocacao, Date criacao, Date atualizacao, float total) {
        this.idLocacao = idLocacao;
        this.atualizacao = atualizacao;
        this.criacao = criacao;
        this.total = total;
    }

    public Diarias() {
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Date getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(Date atualizacao) {
        this.atualizacao = atualizacao;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
