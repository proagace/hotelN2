/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.ServicosTecnicos.Persistencia.DiariasDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.CadastroDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.HospedeDAO;
import br.gov.sp.fatec.Model.Diarias;
import br.gov.sp.fatec.Model.Hospede;
import br.gov.sp.fatec.Model.Cadastro;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago
 */
public class PagamentoControl {
    private DiariasDAO daod = new DiariasDAO();
    private CadastroDAO daol = new CadastroDAO();
    private HospedeDAO daoh = new HospedeDAO();
    
    public List<Diarias> listar(String cpf) {
        java.util.List<Cadastro> temp;
        try {
            Hospede aux = daoh.buscar(new Hospede(cpf));
            if (aux == null) {
                Messages.showError("Hóspede não encontrado");
                return null;
            }
            temp = daol.listar("where idHospede=" + aux.getIdHospede());
            if (temp != null) {
                java.util.List<Diarias> diarias = new java.util.ArrayList<>();
                for (Cadastro locacao : temp) {
                    Diarias obj = new Diarias();
                    obj.setIdLocacao(locacao.getId());
                    obj = daod.buscar(obj);
                    if (obj != null)
                        diarias.add(obj);
                }
                return diarias;
            }
        } catch (SQLException ex) {
            Messages.showError("Erro ao listar diarias: " + ex.getMessage());
        }
        Messages.showError("Hóspede não possui locações");
        return null;
    }
    
    public int getQuartoLocacao(int idLocacao) {
        Cadastro temp = new Cadastro();
        temp.setId(idLocacao);
        try {
            return daol.buscar(temp).getNumQuarto();
        } catch (SQLException ex) {
            Messages.showError("Erro de busca no banco: " + ex.getMessage());
        }
        return -1;
    }
}
