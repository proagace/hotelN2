/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;
import br.gov.sp.fatec.Model.Diaria;
import br.gov.sp.fatec.ServicosTecnicos.BancoFactory;
import br.gov.sp.fatec.ServicosTecnicos.DAO;
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
public class DiariasDAO implements DAO<Diaria> {
    private ResultSet rs;
    private PreparedStatement pst;
    
    @Override
    public boolean adicionar(Diaria item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Diaria item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Diaria buscar(Diaria item) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Diaria> listar(String criterio) throws SQLException {
        List<Diaria> aux = new ArrayList<>();
        String sql = "select * from Diariasacumuladas ";
        if (criterio.length() > 0)
            sql += criterio;
        pst = BancoFactory.abreBanco().prepareStatement(sql);
        try {
            rs = pst.executeQuery();     
            while(rs.next()) {
                aux.add(new Diaria(rs.getInt("idDiariasAcumuladas"), 
                        rs.getInt("idLocacao"), 
                        rs.getDate("dataReferente"),
                        rs.getFloat("valor")
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
