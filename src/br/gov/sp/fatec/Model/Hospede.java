/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Thiago
 */
public class Hospede {
    private int idHospede;
    private String cpf, nome, telefone, email;
    private Date dataNasc;

    public Hospede(int idHospede, String cpf, String nome, String telefone, String email, Date dataNasc) {
        this.idHospede = idHospede;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNasc = dataNasc;
    }

    public Hospede(String cpf, String nome, String telefone, String email, Date dataNasc) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNasc = dataNasc;
    }
    public Hospede(){}

    public Hospede(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + " | E-Mail: " + email;
    }
    
    public int getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(int idHospede) {
        this.idHospede = idHospede;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
    
    
}
