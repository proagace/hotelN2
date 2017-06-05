/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.ServicosTecnicos.Persistencia.DiariasDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.CadastroViewDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.HospedeDAO;
import br.gov.sp.fatec.Model.Diarias;
import br.gov.sp.fatec.Model.Hospede;
import br.gov.sp.fatec.Model.Cadastro;
import br.gov.sp.fatec.Model.TotalConsumo;
import br.gov.sp.fatec.Model.TotalServico;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.CadastroDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.TotalConsumoDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.TotalServicoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class PagamentoControl {
    private DiariasDAO daod = new DiariasDAO();
    private TotalConsumoDAO daoc = new TotalConsumoDAO();
    private TotalServicoDAO daos = new TotalServicoDAO();
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
    
    public List<TotalConsumo> listaConsumo(String cpf){
        java.util.List<Cadastro> temp;          
        Hospede hosp;     
        try {
            hosp = daoh.buscar(new Hospede(cpf));
            if(hosp == null){
                Messages.showError("Hóspede não encontrado");
                return null;
            }
            temp = daol.listar("where idHospede=" + hosp.getIdHospede());
            if (temp != null) {
                java.util.List<TotalConsumo> consumo = new java.util.ArrayList<>();
                for (Cadastro locacao : temp) {
                    TotalConsumo obj = new TotalConsumo();
                    obj.setIdCadastro(locacao.getId());
                    obj = daoc.buscar(obj);
                    if (obj != null)
                        consumo.add(obj);
                }
                return consumo;
            }            
        } catch (SQLException ex) {
            Messages.showError("Erro ao listar consumo: " + ex.getMessage());
        }
        return null;    
    }
    
    public List<TotalServico> listaServico(String cpf){
        java.util.List<Cadastro> temp;          
        Hospede hosp;
        try {
            hosp = daoh.buscar(new Hospede(cpf));
            if(hosp == null){
                Messages.showError("Hóspede não encontrado");
                return null;
            }
            temp = daol.listar("where idHospede=" + hosp.getIdHospede());
            if (temp != null) {
                java.util.List<TotalServico> servico = new java.util.ArrayList<>();
                for (Cadastro locacao : temp) {
                    TotalServico obj = new TotalServico();
                    obj.setIdCadastro(locacao.getId());
                    obj = daos.buscar(obj);
                    if (obj != null)
                        servico.add(obj);
                }
                return servico;
            } 
        } catch (SQLException e) {
            Messages.showError("Erro ao listar servico: " + e.getMessage());
        }
        return null;
    }
    
    public boolean pagtoDiaria(int idCadastro){
        Diarias diarias = new Diarias();
        
        diarias.setPago(true);
        diarias.setIdLocacao(idCadastro);
        
        try {
            daod.atualizar(diarias);
            return true;
        } catch (SQLException ex) {
            Messages.showError("Erro ao realizar pagamento: " + ex.getMessage());
        }
        return false;
    }
    
    public boolean pagtoServico(int idCadastro){
        TotalServico servico = new TotalServico();
        servico.setPago(true);
        servico.setIdCadastro(idCadastro);
        
        try {
            daos.atualizar(servico);
            return true;
        } catch (SQLException ex) {
            Messages.showError("Erro ao realizar pagamento: " + ex.getMessage());
        }
        return false;        
    }
    
    public boolean pagtoConsumo(int idCadastro){
        TotalConsumo consumo = new TotalConsumo();
       
        consumo.setPago(true);
        consumo.setIdCadastro(idCadastro);
        
        try {
            daoc.atualizar(consumo);
            return true;
        } catch (SQLException ex) {
            Messages.showError("Erro ao realizar pagamento: " + ex.getMessage());
        }
        return false;        
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
