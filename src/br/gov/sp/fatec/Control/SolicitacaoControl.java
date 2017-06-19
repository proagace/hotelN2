/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Produto;
import br.gov.sp.fatec.Model.TotalConsumo;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.TotalConsumoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
}
