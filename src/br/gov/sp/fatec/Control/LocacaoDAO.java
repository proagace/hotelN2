/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Locacao;
import br.gov.sp.fatec.ServicosTecnicos.BancoFactory;
import br.gov.sp.fatec.ServicosTecnicos.DAO;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class LocacaoDAO implements DAO<Locacao> {
    private ResultSet rs;
    private PreparedStatement pst;
    
    @Override
    public boolean adicionar(Locacao item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Locacao item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Locacao buscar(Locacao item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "select * from Locacao where idHospede=?"
        );
        pst.setInt(1, item.getIdHospede());
        try {
            rs = pst.executeQuery();
            if (rs.next()) {
                item.setId(rs.getInt("idLocacao"));
                item.setDataCheckIn(rs.getDate("dataCheckOut"));
                item.setIdFuncionario(rs.getInt("idFuncionario"));
                item.setNumQuarto(rs.getInt("numQuarto"));
                return item;
            }
            return null;    
        } catch (SQLException e) {
            Messages.showError("Erro ao buscar produto: " + e.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return null;
    }

    @Override
    public List<Locacao> listar(String criterio) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
