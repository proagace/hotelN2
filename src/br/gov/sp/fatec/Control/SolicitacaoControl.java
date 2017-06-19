/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Cadastro;
import br.gov.sp.fatec.Model.TotalConsumo;
import br.gov.sp.fatec.Model.TotalServico;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.CadastroViewDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.TotalConsumoDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.TotalServicoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Alexandre
 */
public class SolicitacaoControl {
    
    public boolean solicitaProduto(TotalConsumo obj){
        TotalConsumoDAO daoc = new TotalConsumoDAO();
        
        try {
            return daoc.adicionar(obj);
        } catch (SQLException ex) {
            Messages.showError("Erro banco: " + ex.getMessage());
        }
        return false;
    }
    
    public boolean solicitaServico(TotalServico obj){
        TotalServicoDAO daos = new TotalServicoDAO();
        try {
            return daos.adicionar(obj);
        } catch (SQLException e) {
            Messages.showError("Erro banco: " + e.getMessage());
        }
        return false;
    }
    
    public Cadastro buscaCadastro(String cpf, int numQuarto){
        CadastroViewDAO daoc = new CadastroViewDAO();
        
        try {
            List<Cadastro> lcad = daoc.listar("where cpf='"+cpf+"' and numQuarto="+numQuarto);
            if(lcad != null)
                return lcad.get(0);
        } catch (SQLException e) {
            Messages.showError("Erro: " + e.getMessage());            
        }
        return null;
    }
        
    public void buscaQuarto(String cpf, DefaultComboBoxModel combo){
        CadastroViewDAO daoc = new CadastroViewDAO();
        
        try {
            for (Cadastro cadastro : daoc.listar("where cpf='"+ cpf+"' and tipoCadastro='Locacao'")) {
                combo.addElement(cadastro.getNumQuarto());
            }
        } catch (SQLException e) {
            Messages.showError("Erro ao buscar quartos: " + e.getMessage());
        }
    }    
    
       
}
