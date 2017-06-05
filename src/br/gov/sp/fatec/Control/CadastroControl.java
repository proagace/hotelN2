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
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.CadastroDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.DiariasDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.HospedeDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.QuartoDAO;
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
    public List<Quarto> listarQuartos() {
        QuartoDAO daoq = new QuartoDAO();
        try {
            return daoq.listar("");
        } catch (SQLException ex) {
            Messages.showError("Erro ao listar quartos: " + ex.getMessage());
        }
        return null;
    }
    
    public List<Cadastro> listarReservas(int idHospede) {
        CadastroDAO daoc = new CadastroDAO();
        try {
            return daoc.listar("where tipoCadastro = 'Reserva' and idHospede = " + idHospede);
        } catch (SQLException ex) {
            Messages.showError("Erro ao listar Cadastros: " + ex.getMessage());
        }
        return null;
    }
    
    public boolean realizarCadastro(int numQuarto, int idHospede,  Date dataCheckIn, 
        Date dataCheckOut, int idFuncionario, String tipoCadastro) {
        CadastroDAO daoc = new CadastroDAO();
        QuartoDAO daoq = new QuartoDAO();
        try {
            daoc.adicionar(new Cadastro(numQuarto, idHospede, dataCheckIn, dataCheckOut, 
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
        CadastroDAO daoc = new CadastroDAO();
        try {
            return daoc.atualizar(obj);
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
        CadastroDAO daoc = new CadastroDAO();
        DiariasDAO daod = new DiariasDAO();
        QuartoDAO daoq= new QuartoDAO();
        try {
            //daoq.buscar(item)
            Quarto quarto = daoq.buscar(new Quarto(numQuarto));
            quarto.setDisponivel(true);
            daoq.atualizar(quarto);            
            return (daod.remover(new Diarias(obj.getId())) && daoc.remover(obj));
        } catch (SQLException ex) {
            Messages.showError("Erro ao cancelar a reserva: " + ex.getMessage());

        }
    return false;          
    }
}
