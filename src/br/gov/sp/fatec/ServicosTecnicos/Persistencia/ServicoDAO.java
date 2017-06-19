/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.ServicosTecnicos.Persistencia;

import br.gov.sp.fatec.Model.Servico;
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
public class ServicoDAO implements DAO<Servico>{
    private PreparedStatement pst;
    private ResultSet rs;
    

    @Override
    public boolean adicionar(Servico item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(Servico item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Servico item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Servico buscar(Servico item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Servico> listar(String criterio) throws SQLException {
        List<Servico> aux = new ArrayList<>();
        String sql = "select * from Servico ";
        if (criterio.length() > 0)
            sql += criterio;
        pst = BancoFactory.abreBanco().prepareStatement(sql);
        try {
            rs = pst.executeQuery();     
            while(rs.next()) {
                aux.add(new Servico(rs.getInt("idServico"),
                        rs.getString("tipoServico"),
                        rs.getString("descServico"),
                        rs.getFloat("vlrServico")
                ));
            }
            return aux;
        } catch (SQLException e) {
            Messages.showError("Erro ao listar serviços: " + e.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return null;
    }
    
}
