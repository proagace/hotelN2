/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Produto;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.TipoProdutoEnum;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

/**
 *
 * @author Thiago
 */
public class ProdutoControl {
    public void preencherTipos(JComboBox combo) {
        DefaultComboBoxModel<TipoProdutoEnum> modelo = new DefaultComboBoxModel<>();
        for (TipoProdutoEnum tipo : TipoProdutoEnum.values()) {
            modelo.addElement(tipo);
        }
        combo.setModel(modelo);
        combo.setSelectedIndex(-1);
    }
    
    public boolean inserir(String desc, float valor, String tipo, String imagem) {
        ProdutoDAO temp = new ProdutoDAO();
        Produto aux = new Produto();
        aux.setDescricao(desc);
        aux.setValor(valor);
        aux.setTipo(TipoProdutoEnum.valueOf(tipo));
        aux.setImagem(imagem);
        try {
            temp.adicionar(aux);
        } catch (SQLException ex) {
            Messages.showError("Erro ao inserir" + ex.getMessage());
            return false;
        }
        Messages.showInformation("Produto inserido.");
        return true;
    }
    
    public void limpar(JInternalFrame view) {
        for (Object component : view.getContentPane().getComponents()) {
            if (component instanceof JTextField)
                ((JTextField)component).setText("");
            else if (component instanceof JComboBox)
                ((JComboBox)component).setSelectedIndex(-1);
        }
    }
}
