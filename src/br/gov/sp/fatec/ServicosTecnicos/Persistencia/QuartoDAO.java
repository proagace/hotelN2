/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.ServicosTecnicos.Persistencia;

import br.gov.sp.fatec.Model.Quarto;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class QuartoDAO implements DAO<Quarto>{
    private ResultSet rs;
    private PreparedStatement pst;
    private Statement stm;

    @Override
    public boolean adicionar(Quarto item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Quarto item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Quarto buscar(Quarto item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "select * from Quarto where numQuarto = ?"
        );
        pst.setInt(1, item.getNumQuarto());
        rs = pst.executeQuery();
        if (rs.next()) {
            item.setDisponivel(rs.getBoolean("disponibilidade"));
            item.setTipoQuarto(rs.getString("tipo"));
            item.setValorDiaria(rs.getFloat("vlrDiaria"));
        } else
            item = null;
        return item;
    }

    @Override
    public List<Quarto> listar(String criterio) throws SQLException {
        List<Quarto> aux = new ArrayList();
        String sql = "select * from Quarto where disponibilidade=1";
        pst = BancoFactory.abreBanco().prepareStatement(sql);
        try {
            rs = pst.executeQuery();
            while(rs.next()){
                aux.add(new Quarto(rs.getInt("numQuarto"),
                        rs.getString("tipo"), 
                        rs.getBoolean("disponibilidade"),
                        rs.getFloat("vlrDiaria")));
            }
            return aux;
        } catch (SQLException e) {
            Messages.showError("Erro ao listar quartos: " + e.getMessage());
        }finally{
            BancoFactory.fechaBanco();
        }
        return null;
    }    

    @Override
    public boolean atualizar(Quarto item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "update quarto set tipo=?, disponibilidade=?, vlrDiaria=? where numQuarto=?");
        pst.setString(1, item.getTipoQuarto());
        pst.setBoolean(2, item.isDisponivel());
        pst.setFloat(3, item.getValorDiaria());
        pst.setInt(4, item.getNumQuarto());
        
        try {
            int rows = pst.executeUpdate();
            return(rows > 0);
            
        } catch (SQLException e) {
            Messages.showError("Erro ao atualizar quarto" + e.getMessage());
        }
        
        return false;
    }  
}