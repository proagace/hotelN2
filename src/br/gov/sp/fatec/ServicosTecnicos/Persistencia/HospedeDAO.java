/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.ServicosTecnicos.Persistencia;

import br.gov.sp.fatec.Model.Hospede;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class HospedeDAO implements DAO<Hospede> {
    private PreparedStatement pst;
    private ResultSet rs;
    private String sql;
    
    @Override
    public boolean adicionar(Hospede item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "insert into Hospede values (null, ?, ?, ?, ?, ?)"
        );
        pst.setString(1, item.getCpf());
        pst.setString(2, item.getNome());
        pst.setString(3, item.getTelefone());
        pst.setDate(4, new java.sql.Date(item.getDataNasc().getTime()));
        pst.setString(5, item.getEmail());
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
    public boolean remover(Hospede item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hospede buscar(Hospede item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "select * from Hospede where cpf=?"
        );
        pst.setString(1, item.getCpf());
        try {
            rs = pst.executeQuery();
            if (rs.next()) {
                item.setDataNasc(rs.getDate("dataNasc"));
                item.setEmail(rs.getString("email"));
                item.setIdHospede(rs.getInt("idHospede"));
                item.setNome(rs.getString("nome"));
                item.setTelefone(rs.getString("telefone"));
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
    public List<Hospede> listar(String criterio) throws SQLException {
        sql = "select * from Hospede ";
        if (criterio.length() != 0)
            sql += criterio;
        pst = BancoFactory.abreBanco().prepareStatement(
                sql
        );
        try {
            rs = pst.executeQuery();
            List<Hospede> resultado = new ArrayList<>();
            while(rs.next()) {
                resultado.add(new Hospede(rs.getInt("idHospede"),
                                          rs.getString("cpf"), 
                                          rs.getString("nome"),
                                          rs.getString("telefone"),
                                          rs.getString("email"),
                                          rs.getDate("dataNasc")));
            }
            return resultado;
        } catch (SQLException ex) {
            Messages.showError("Erro ao listar hospedes: " + ex.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return null;
    }

    @Override
    public boolean atualizar(Hospede item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
