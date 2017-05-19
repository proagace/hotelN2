/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Diaria;
import br.gov.sp.fatec.Model.Hospede;
import br.gov.sp.fatec.Model.Locacao;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class PagamentoControl {
    public List<Diaria> listar(String cpf) {
        DiariasDAO daod = new DiariasDAO();
        LocacaoDAO daol = new LocacaoDAO();
        HospedeDAO daoh = new HospedeDAO();
        Locacao temp;
        try {
            Hospede aux = daoh.buscar(new Hospede(cpf));
            if (aux == null) {
                Messages.showError("Hóspede não encontrado");
                return null;
            }
            temp = daol.buscar(new Locacao(aux.getIdHospede()));
            if (temp != null)
                return daod.listar("where idLocacao = " + temp.getId());
        } catch (SQLException ex) {
            Messages.showError("Erro ao listar diarias: " + ex.getMessage());
        }
        Messages.showError("Hóspede não possui locações");
        return null;
    }
}
