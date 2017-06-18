/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Control;

import br.gov.sp.fatec.Model.Cadastro;
import br.gov.sp.fatec.Model.Quarto;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.CadastroDAO;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.QuartoDAO;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.sql.SQLException;

/**
 *
 * @author Alexandre
 */
public class EstadiaControl {
    
    public boolean encerrar(int idCadastro, int numQuarto){
        CadastroDAO daocad = new CadastroDAO();
        QuartoDAO daoquarto = new QuartoDAO();
        Cadastro cad = new Cadastro();
        
        cad.setId(idCadastro);
        cad.setTipoCadastro("Encerrado");
  
        try {
            Quarto quarto = daoquarto.buscar(new Quarto(numQuarto));
            quarto.setDisponivel(true);
            daoquarto.atualizar(quarto);
            daocad.atualizar(cad);
            return true;
        } catch (SQLException e) {
            Messages.showError("Erro ao encerrar estadia!" + e.getMessage());
        }
        return false;
   
    }
    
    
}
