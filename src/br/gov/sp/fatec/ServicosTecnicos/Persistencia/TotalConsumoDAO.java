/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.ServicosTecnicos.Persistencia;

import br.gov.sp.fatec.Model.TotalConsumo;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class TotalConsumoDAO implements DAO<TotalConsumo>{
    private PreparedStatement pst;
    private ResultSet rs;


    @Override
    public List listar(String criterio) throws SQLException {
        List<TotalConsumo> aux = new ArrayList<>();
        String sql = "select * from totConsumo where pagoConsumo=0";
        if (criterio.length() > 0)
            sql += criterio;
        pst = BancoFactory.abreBanco().prepareStatement(sql);
        try {
            rs = pst.executeQuery();     
            while(rs.next()) {
                aux.add(new TotalConsumo(
                        rs.getInt("idCadastro"),
                        rs.getFloat("total")
                ));
            }
            return aux;
        } catch (SQLException e) {
            Messages.showError("Erro ao listar consumo: " + e.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return null;    
    }

    @Override
    public boolean adicionar(TotalConsumo item) throws SQLException {
        pst=BancoFactory.abreBanco().prepareStatement(
                "insert into consumo values (null, ?, ?, ?, ?)");
        
        pst.setInt(1, item.getIdCadastro());
        pst.setInt(2, item.getIdProduto());
        pst.setInt(3, item.getQtdConsumo());
        pst.setBoolean(4, item.isPago());
        
        try {
            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            Messages.showError("Erro ao executar inserção: " + e.getMessage());
        }finally{
            BancoFactory.fechaBanco();
        }
        return false;
    }

    @Override
    public boolean atualizar(TotalConsumo item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "update viewConsumo set pagoConsumo=? where idCadastro=?"
        );
        pst.setBoolean(1, item.isPago());
        pst.setInt(2, item.getIdCadastro());
        
        try {
            int rows = pst.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            Messages.showError("Erro no banco: " + e.getMessage());
        }finally{
            BancoFactory.fechaBanco();
        }
        return false;  
    }

    @Override
    public boolean remover(TotalConsumo item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TotalConsumo buscar(TotalConsumo item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "select * from totConsumo where idCadastro=? and pagoConsumo=0"
        );
        pst.setInt(1, item.getIdCadastro());
        try {
            rs = pst.executeQuery();
            if (rs.next()) {
                item.setIdCadastro(rs.getInt("idCadastro"));
                item.setTotal(rs.getFloat("total"));
                return item;
            }   
        } catch (SQLException e) {
            Messages.showError("Erro ao buscar consumo: " + e.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return null;
    }
    
}
