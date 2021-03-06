/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.ServicosTecnicos.Persistencia;
import br.gov.sp.fatec.Model.Diarias;
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
public class DiariasDAO implements DAO<Diarias> {
    private ResultSet rs;
    private PreparedStatement pst;
    
    @Override
    public boolean adicionar(Diarias item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Diarias item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "delete from Diarias where idCadastro=?");
        pst.setInt(1, item.getIdLocacao());
        try {
            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (SQLException ex) {
            Messages.showError("Erro banco: " + ex.getMessage());
        }finally{
            BancoFactory.fechaBanco();
        }
        return false;
    }

    @Override
    public Diarias buscar(Diarias item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "select * from Diarias where idCadastro=? and pagoDiaria=0"
        );
        pst.setInt(1, item.getIdLocacao());
        try {
            rs = pst.executeQuery();
            if (rs.next()) {
                item.setAtualizacao(rs.getDate("dataAtualizacao"));
                item.setTotal(rs.getFloat("vlrDiarias"));
                return item;
            }   
        } catch (SQLException e) {
            Messages.showError("Erro ao buscar diária: " + e.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return null;
    }

    @Override
    public List<Diarias> listar(String criterio) throws SQLException {
        List<Diarias> aux = new ArrayList<>();
        String sql = "select * from Diarias ";
        if (criterio.length() > 0)
            sql += criterio;
        pst = BancoFactory.abreBanco().prepareStatement(sql);
        try {
            rs = pst.executeQuery();     
            while(rs.next()) {
                aux.add(new Diarias(
                        rs.getInt("idCadastro"),
                        rs.getDate("dataCriacao"),
                        rs.getDate("dataAtualizacao"),
                        rs.getFloat("vlrDiarias")
                ));
            }
            return aux;
        } catch (SQLException e) {
            Messages.showError("Erro ao listar diárias: " + e.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return null;
    }

    @Override
    public boolean atualizar(Diarias item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "update Diarias set pagoDiaria=? where idCadastro=?"
        );
        pst.setBoolean(1, item.isPago());
        pst.setInt(2, item.getIdLocacao());
        
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
    
}
