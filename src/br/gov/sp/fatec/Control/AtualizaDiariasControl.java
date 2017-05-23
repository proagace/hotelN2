/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Diarias;
import br.gov.sp.fatec.Model.Locacao;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.LocacaoDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Thiago
 */
public class AtualizaDiariasControl {
    private LocacaoDAO daol = new LocacaoDAO();
    
    public void atualizar() {
        try {
            Date now = new Date();
            List<Locacao> temp = daol.listar("");
            if (temp != null)
                for (Locacao locacao : temp) {
                    locacao.setVlrDiarias(TimeUnit.DAYS.convert((now.getTime() - locacao.getDataCriacao().getTime()), TimeUnit.MILLISECONDS) * locacao.getVlrDiaria());
                    locacao.setDataAtualizacao(now);
                    daol.atualizar(locacao);
                }
        } catch (SQLException ex) {
            Messages.showError("Erro banco: " + ex.getMessage());
        }
    }
}
