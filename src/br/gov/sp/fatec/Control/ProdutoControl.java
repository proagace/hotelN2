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
    

}
