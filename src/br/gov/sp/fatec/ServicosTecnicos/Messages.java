/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.ServicosTecnicos;

import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class Messages extends JOptionPane {
    public static void show(String msg) {
        showMessageDialog(null, msg);
    }
    
    public static void showError(String msg) {
        showMessageDialog(null, msg, "", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showInformation(String msg) {
        showMessageDialog(null, msg, "", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showQuestion(String msg) {
        showMessageDialog(null, msg, "", JOptionPane.QUESTION_MESSAGE);
    }
}
