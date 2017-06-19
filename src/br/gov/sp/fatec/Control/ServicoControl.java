/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Servico;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.ServicoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class ServicoControl {
    public List<Servico> listaServico(){
        ServicoDAO daoserv = new ServicoDAO();
        try {
            return daoserv.listar("");
        } catch (SQLException e) {
            Messages.showError("Erro ao listar serviços" + e.getMessage());
        }
        return null;
    }
}
