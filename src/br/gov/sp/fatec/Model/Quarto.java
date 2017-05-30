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
public class Quarto {
    private int numQuarto;
    private String tipoQuarto;
    private boolean disponivel;
    private float valorDiaria;

    public Quarto(int numQuarto, String tipoQuarto, boolean disponivel, float valorDiaria) {
        this.numQuarto = numQuarto;
        this.tipoQuarto = tipoQuarto;
        this.disponivel = disponivel;
        this.valorDiaria = valorDiaria;
    }

    public Quarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public Quarto(){}
    
    public int getNumQuarto() {
        return numQuarto;
    }


    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
           
}
