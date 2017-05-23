/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.ServicosTecnicos.Persistencia;

import br.gov.sp.fatec.Model.Quarto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class QuartoDAO implements DAO<Quarto> {
    private ResultSet rs;
    private PreparedStatement pst;
    
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
            item.setDisponibilidade(rs.getBoolean("disponibilidade"));
            item.setTipo(rs.getString("tipo"));
            item.setVlrDiaria(rs.getFloat("vlrDiaria"));
        } else
            item = null;
        return item;
    }

    @Override
    public List<Quarto> listar(String criterio) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(Quarto item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
