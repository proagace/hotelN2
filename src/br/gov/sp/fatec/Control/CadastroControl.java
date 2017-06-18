/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Cadastro;
import br.gov.sp.fatec.Model.Diarias;
import br.gov.sp.fatec.Model.Hospede;
import br.gov.sp.fatec.Model.Quarto;
import br.gov.sp.fatec.Model.TotalConsumo;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.CadastroDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.CadastroViewDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.DiariasDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.HospedeDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.QuartoDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.TotalConsumoDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago
 */
public class CadastroControl {
    HospedeDAO daohosp = new HospedeDAO();
    Hospede hosp;
    CadastroDAO daocad = new CadastroDAO();
    
    public List<Quarto> listarQuartos() {
        QuartoDAO daoq = new QuartoDAO();
        try {
            return daoq.listar("");
        } catch (SQLException ex) {
            Messages.showError("Erro ao listar quartos: " + ex.getMessage());
        }
        return null;
    }
    
    public List<Cadastro> listarLocacao(String cpf){
        
        try {    
            hosp = daohosp.buscar(new Hospede(cpf));
            if(hosp == null){
                Messages.showError("Hóspede não encontrado");
                return null;
            }            
            return daocad.listar("where tipoCadastro = 'Locacao' and idHospede="+hosp.getIdHospede());
        } catch (SQLException e) {
            Messages.showError("Erro ao listar locação: " + e.getMessage());            
        }
        return null;     
    }
    
    public boolean verificaConsumo(int idCadastro){
        TotalConsumoDAO daocons = new TotalConsumoDAO();
        java.util.List<Cadastro> temp;                  

            
        try {
            TotalConsumo obj = new TotalConsumo();
            obj.setIdCadastro(idCadastro);
            obj = daocons.buscar(obj);
            return obj == null;  
        } catch (SQLException e) {
            Messages.showError("Erro ao verificar consumo: " + e.getMessage());            
        }
        
        return false;
    }
    
    public List<Cadastro> listarReservas(int idHospede) {
        try {
            return daocad.listar("where tipoCadastro = 'Reserva' and idHospede = " + idHospede);
        } catch (SQLException ex) {
            Messages.showError("Erro ao listar Cadastros: " + ex.getMessage());
        }
        return null;
    }
    
    public boolean realizarCadastro(int numQuarto, int idHospede,  Date dataCheckIn, 
        Date dataCheckOut, int idFuncionario, String tipoCadastro) {
        QuartoDAO daoq = new QuartoDAO();
        try {
            daocad.adicionar(new Cadastro(numQuarto, idHospede, dataCheckIn, dataCheckOut, 
                                idFuncionario, tipoCadastro));
            Quarto quarto = daoq.buscar(new Quarto(numQuarto));
            quarto.setDisponivel(false);
            daoq.atualizar(quarto);
            return true;
        } catch (SQLException ex) {
            Messages.showError("Erro ao realizar locação: " + ex.getMessage());
        }
        return false;
    }
    
    public boolean realizarLocacaoReserva(Cadastro obj) {
        try {
            return daocad.atualizar(obj);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Hospede verificaHospede(Hospede obj) {
        HospedeDAO daoh = new HospedeDAO();
        try {
            return daoh.buscar(obj);
        } catch (SQLException ex) {
            Messages.showError("Erro ao buscar hóspede: " + ex.getMessage());
        }
        return null;
    }
    
    public boolean cancelaReserva(Cadastro obj, int numQuarto){
        DiariasDAO daod = new DiariasDAO();
        QuartoDAO daoq= new QuartoDAO();
        try {
            //daoq.buscar(item)
            Quarto quarto = daoq.buscar(new Quarto(numQuarto));
            quarto.setDisponivel(true);
            daoq.atualizar(quarto);            
            return (daod.remover(new Diarias(obj.getId())) && daocad.remover(obj));
        } catch (SQLException ex) {
            Messages.showError("Erro ao cancelar a reserva: " + ex.getMessage());

        }
    return false;          
    }
}
