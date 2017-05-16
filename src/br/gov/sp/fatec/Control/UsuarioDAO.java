/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Usuario;
import br.gov.sp.fatec.ServicosTecnicos.BancoFactory;
import br.gov.sp.fatec.ServicosTecnicos.DAO;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class UsuarioDAO implements DAO<Usuario> {
    private ResultSet rs;
    private PreparedStatement pst;
    
    @Override
    public boolean adicionar(Usuario item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Usuario item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscar(Usuario item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "select * from Usuarios where nome = ?"
        );
        pst.setString(1, item.getNome());
        try {
            rs = pst.executeQuery();
            if (rs.next())
                return new Usuario(rs.getString("nome"), rs.getString("senha"), rs.getInt("nivel"));
        } catch (Exception e) {
            Messages.showError("Erro na leitura do banco: " + e.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return null;
    }

    @Override
    public List<Usuario> listar(String criterio) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
