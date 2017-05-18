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
public class Diaria {
    private int cod, idLocacao;
    private Date referente;
    private float valor;

    public Diaria(int cod, int idLocacao, Date referente, float valor) {
        this.cod = cod;
        this.idLocacao = idLocacao;
        this.referente = referente;
        this.valor = valor;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Date getReferente() {
        return referente;
    }

    public void setReferente(Date referente) {
        this.referente = referente;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
