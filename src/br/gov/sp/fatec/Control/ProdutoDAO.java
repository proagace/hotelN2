/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Produto;
import br.gov.sp.fatec.ServicosTecnicos.BancoFactory;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.DAO;
import br.gov.sp.fatec.ServicosTecnicos.TipoProdutoEnum;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class ProdutoDAO implements DAO<Produto> {
    private ResultSet rs;
    private PreparedStatement pst;
    
    @Override
    public boolean adicionar(Produto item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "insert into Produto (descProduto, vlrProduto, tipoProduto, imgProduto) values (?, ?, ?, ?)"
        );
        pst.setString(1, item.getDescricao());
        pst.setFloat(2, item.getValor());
        pst.setString(3, String.valueOf(item.getTipo()));
        pst.setString(4, item.getImagem());
        try {
            int rows = pst.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
           Messages.showError("Erro ao executar inserção: " + e.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return false;
    }

    @Override
    public boolean remover(Produto item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "delete from Produto where descProduto=?"
        );
        pst.setString(1, item.getDescricao());
        try {
            int rows = pst.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            Messages.showError("Erro ao remover produto: " + e.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return false;
    }

    @Override
    public Produto buscar(Produto item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "select * from Produto where descProduto=?"
        );
        pst.setString(1, item.getDescricao());
        try {
            rs = pst.executeQuery();
            if (rs.next()) {
                item.setIdProduto(rs.getInt("idProduto"));
                item.setValor(rs.getFloat("vlrProduto"));
                item.setTipo(TipoProdutoEnum.valueOf(rs.getString("tipoProduto")));
                item.setImagem(rs.getString("imgProduto"));
                return item;
            }
            return (item = null);    
        } catch (SQLException e) {
            Messages.showError("Erro ao buscar produto: " + e.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return null;
    }

    @Override
    public List<Produto> listar(String criterio) throws SQLException {
        List<Produto> aux = new ArrayList<>();
        String sql = "select * from Produto";
        if (criterio.length() > 0)
            sql += criterio;
        pst = BancoFactory.abreBanco().prepareStatement(sql);
        try {
            rs = pst.executeQuery();     
            while(rs.next()) {
                aux.add(new Produto(rs.getInt("idProduto"), 
                        rs.getString("descProduto"), 
                        rs.getFloat("vlrProduto"),
                        TipoProdutoEnum.valueOf(rs.getString("tipoProduto")),
                        rs.getString("imgProduto")
                ));
            }
            return aux;
        } catch (SQLException e) {
            Messages.showError("Erro ao listar produtos: " + e.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return null;
    }
    
}
