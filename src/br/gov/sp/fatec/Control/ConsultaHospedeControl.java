/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Hospede;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.HospedeDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago
 */
public class ConsultaHospedeControl {
    public List<Hospede> pesquisa(String parametro) {
        try {
            HospedeDAO daoh = new HospedeDAO();
            if (parametro.length() != 0)
                return daoh.listar("where nome like '%" + parametro + "%'");
            else
                return daoh.listar("");

        } catch (SQLException ex) {
            Messages.showError("Erro de consulta: " + ex.getMessage());
        }
        return null;
    }
}
