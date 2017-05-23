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
public class Locacao {
    private int id, idHospede, numQuarto, idFuncionario;
    private Date dataCheckIn, dataCheckOut, dataCriacao, dataAtualizacao;
    private float vlrDiaria, vlrDiarias;

    public Locacao(int id, int numQuarto, float vlrDiaria, int idHospede, Date dataCheckIn, Date dataCheckOut, int idFuncionario, Date dataCriacao, Date dataAtualizacao, float vlrDiarias) {
        this.id = id;
        this.idHospede = idHospede;
        this.numQuarto = numQuarto;
        this.idFuncionario = idFuncionario;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.vlrDiaria = vlrDiaria;
        this.vlrDiarias = vlrDiarias;
    }

    public Locacao(int idHospede) {
        this.idHospede = idHospede;
    }
    
    public Locacao() { }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(int idHospede) {
        this.idHospede = idHospede;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(Date dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(Date dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public float getVlrDiaria() {
        return vlrDiaria;
    }

    public void setVlrDiaria(float vlrDiaria) {
        this.vlrDiaria = vlrDiaria;
    }

    public float getVlrDiarias() {
        return vlrDiarias;
    }

    public void setVlrDiarias(float vlrDiarias) {
        this.vlrDiarias = vlrDiarias;
    }
    
    
}
