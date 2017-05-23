/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Model;

/**
 *
 * @author Thiago
 */
public class Quarto {
    private int numQuarto;
    private String tipo;
    private boolean disponibilidade;
    private float vlrDiaria;

    public Quarto(int numQuarto, String tipo, boolean disponibilidade, float vlrDiaria) {
        this.numQuarto = numQuarto;
        this.tipo = tipo;
        this.disponibilidade = disponibilidade;
        this.vlrDiaria = vlrDiaria;
    }

    public Quarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }
    
    public Quarto() {
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public float getVlrDiaria() {
        return vlrDiaria;
    }

    public void setVlrDiaria(float vlrDiaria) {
        this.vlrDiaria = vlrDiaria;
    }
    
    
}
