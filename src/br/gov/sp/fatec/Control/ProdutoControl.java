/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Cadastro;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.ProdutoDAO;
import br.gov.sp.fatec.Model.Produto;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.CadastroViewDAO;
import br.gov.sp.fatec.ServicosTecnicos.TipoProdutoEnum;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Thiago
 */
public class ProdutoControl {
    public boolean inserir(Produto aux) {
        ProdutoDAO temp = new ProdutoDAO();
        try {
            temp.adicionar(aux);
        } catch (SQLException ex) {
            Messages.showError("Erro ao inserir" + ex.getMessage());
            return false;
        }
        Messages.showInformation("Produto inserido.");
        return true;
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
}
