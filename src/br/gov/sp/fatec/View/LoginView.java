/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.View;

import br.gov.sp.fatec.ServicosTecnicos.Persistencia.UsuarioDAO;
import br.gov.sp.fatec.Model.Usuario;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Thiago
 */
public class LoginView extends javax.swing.JInternalFrame {
    private MainView main;
    /**
     * Creates new form LoginView
     * @param main
     */
    public LoginView(MainView main) {
        initComponents();
        getRootPane().setDefaultButton(btnLogar);
        this.main = main;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnLogar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();

        setTitle("Login");
        setFrameIcon(new ImageIcon(System.getProperty("user.dir") + File.separator +
            "images" + File.separator + "LogoSimple.png"));
    setVisible(true);

    jLabel1.setText("Usuário:");

    jLabel2.setText("Senha:");

    btnLogar.setMnemonic('L');
    btnLogar.setText("Logar");
    btnLogar.setToolTipText("");
    btnLogar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLogarActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(14, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLogar)
            .addGap(72, 72, 72))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(btnLogar)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        UsuarioDAO dao = new UsuarioDAO();
        Usuario temp = new Usuario();
        Usuario compare = null;
        temp.setNome(txtUsuario.getText());
        temp.setSenha(txtSenha.getText());
        try {
            compare = dao.buscar(temp);
        } catch (SQLException ex) {
            Messages.showError("Erro no banco: " + ex.getMessage());
        }
        if (compare != null && compare.getSenha().equals(temp.getSenha())) {
            main.toggleMenus();
            MainView.funcionarioLogado = compare;
            try {
                this.setClosed(true);
            } catch (PropertyVetoException ex) {
                Messages.showError("Erro ao fechar view: " + ex.getMessage());
            }
        } else {
            Messages.showInformation("Usuário e/ou senha inválido(s)!");
        }
    }//GEN-LAST:event_btnLogarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
