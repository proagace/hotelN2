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
public class Usuario {
    private String nome;
    private String senha;
    private int nivel;

    public Usuario(){}

    public Usuario(String nome, String senha, int nivel) {
        this.nome = nome;
        this.senha = senha;
        this.nivel = nivel;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
}
