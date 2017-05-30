/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.ServicosTecnicos.Persistencia;

import br.gov.sp.fatec.Model.Cadastro;
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
public class CadastroDAO implements DAO<Cadastro> {
    private ResultSet rs;
    private PreparedStatement pst;
    
    @Override
    public boolean adicionar(Cadastro item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                    "insert into Cadastro (numQuarto, idHospede, dataCheckIn,"
                            + " dataCheckOut, idFuncionario, tipoCadastro) values (?, ?, ?, ?, ?, ?)");
        pst.setInt(1, item.getNumQuarto());
        pst.setInt(2, item.getIdHospede());        
        pst.setDate(3, item.getDataCheckIn());
        pst.setDate(4, item.getDataCheckOut());
        pst.setInt(5, item.getIdFuncionario());
        pst.setString(6, item.getTipoCadastro());
        
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
    public boolean remover(Cadastro item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "delete from Cadastro where idCadastro=?");
        pst.setInt(1, item.getId());
        
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
    public Cadastro buscar(Cadastro item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "select * from Cadastro where idHospede=?"
        );
        pst.setString(1, item.getCpf());
        try {
            rs = pst.executeQuery();
            if (rs.next()) {
                item.setId(rs.getInt("idCadastro"));
                item.setDataCheckIn(rs.getDate("dataCheckOut"));
                item.setIdFuncionario(rs.getInt("idFuncionario"));
                item.setNumQuarto(rs.getInt("numQuarto"));
                return item;
            }
            return null;    
        } catch (SQLException e) {
            Messages.showError("Erro ao buscar cadastro: " + e.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return null;
    }

    @Override
    public List<Cadastro> listar(String criterio) throws SQLException {
        List<Cadastro> aux = new ArrayList<>();
        String sql = "select * from Cadastro ";
        if (criterio.length() > 0)
            sql += criterio;
        pst = BancoFactory.abreBanco().prepareStatement(sql);
        try {
            rs = pst.executeQuery();     
            while(rs.next()) {
                aux.add(new Cadastro(rs.getInt("idCadastro"), 
                        rs.getInt("numQuarto"), 
                        rs.getInt("idHospede"),
                        rs.getDate("dataCheckIn"),
                        rs.getDate("dataCheckOut"),
                        rs.getInt("idFuncionario"),
                        rs.getString("tipoCadastro")
                ));
            }
            return aux;
        } catch (SQLException e) {
            Messages.showError("Erro ao listar cadastros: " + e.getMessage());
        } finally {
            BancoFactory.fechaBanco();
        }
        return null;
    }

    @Override
    public boolean atualizar(Cadastro item) throws SQLException {
        pst = BancoFactory.abreBanco().prepareStatement(
                "update Cadastro set tipoCadastro = ? where idCadastro = ?"
        );
        pst.setString(1, item.getTipoCadastro());
        pst.setInt(2, item.getId());
        
        int rows = pst.executeUpdate();
        return rows > 0;
    }
    
}
