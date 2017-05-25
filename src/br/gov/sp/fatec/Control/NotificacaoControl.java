/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Diarias;
import br.gov.sp.fatec.Model.Hospede;
import br.gov.sp.fatec.Model.Cadastro;
import br.gov.sp.fatec.Model.Quarto;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.DiariasDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.CadastroDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.QuartoDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago
 */
public class NotificacaoControl {
    private DiariasDAO daod = new DiariasDAO();
    private CadastroDAO daol = new CadastroDAO();
    private QuartoDAO daoq = new QuartoDAO();
    
    public List<Diarias> listar() {
        try {
            return daod.listar("where DATEDIFF(now(), dataCriacao) >= 7");
        } catch (SQLException ex) {
            Messages.showError("Erro ao listar diarias: " + ex.getMessage());
        }
        Messages.showError("Hóspede não possui locações");
        return null;
    }
}
