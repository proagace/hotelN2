/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Diaria;
import br.gov.sp.fatec.Model.Locacao;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class PagamentoControl {
    public List<Diaria> listar(int idHospede) {
        DiariasDAO daod = new DiariasDAO();
        LocacaoDAO daol = new LocacaoDAO();
        Locacao temp;
        try {
            temp = daol.buscar(new Locacao(idHospede));
            if (temp != null)
                return daod.listar("where idLocacao = " + temp.getId());
        } catch (SQLException ex) {
            Messages.showError("Erro ao listar diarias: " + ex.getMessage());
        }
        Messages.showError("Hóspede não possui locações");
        return null;
    }
}
