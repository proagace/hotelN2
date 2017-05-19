/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Hospede;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago
 */
public class CadastroHospedeControl {
    private HospedeDAO dao = new HospedeDAO();
    public Hospede buscar (Hospede obj) {
        try {
            return dao.buscar(obj);
        } catch (SQLException ex) {
            Messages.showError("Erro banco: " + ex.getMessage());
        }
        return null;
    }
    
    public boolean adicionar (Hospede obj) {
        try {
            return dao.adicionar(obj);
        } catch (SQLException ex) {
            Messages.showError("Erro banco: " + ex.getMessage());
        }
        return false;
    }
}
