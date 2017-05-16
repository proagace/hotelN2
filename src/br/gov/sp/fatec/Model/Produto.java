/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Model;

import br.gov.sp.fatec.ServicosTecnicos.TipoProdutoEnum;
import java.util.Objects;

/**
 *
 * @author Thiago
 */
public class Produto {
    private int idProduto;
    private String descricao;
    private float valor;
    private TipoProdutoEnum tipo;
    private String imagem;

    public Produto(int idProduto, String descricao, float valor, TipoProdutoEnum tipo, String imagem) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.imagem = imagem;
    }

    public Produto() {}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public TipoProdutoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoProdutoEnum tipo) {
        this.tipo = tipo;
    }
    
    
}
