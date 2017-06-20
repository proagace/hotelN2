/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.View;

import br.gov.sp.fatec.Control.ProdutoControl;
import br.gov.sp.fatec.Model.Produto;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.ServicosTecnicos.TipoProdutoEnum;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;
import javafx.stage.FileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Thiago
 */
public class CadastroProdutoView extends javax.swing.JInternalFrame {
    private DefaultComboBoxModel<TipoProdutoEnum> modelo;
    private static CadastroProdutoView window;
    /**
     * Creates new form NewJInternalFrame
     */
    
    public static CadastroProdutoView getInstance() {
        if (window != null) {
            window.dispose();
            window = null;
        } 
        window = new CadastroProdutoView();
        return window;
    }
    
    private CadastroProdutoView() {
        initComponents();
        getRootPane().setDefaultButton(btn_enviar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        cb_tipo = new javax.swing.JComboBox<>();
        btn_limpar = new javax.swing.JButton();
        btn_enviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_desc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbl_icon = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cadastro de Produtos");
        setFrameIcon(new ImageIcon(System.getProperty("user.dir") + File.separator +
            "images" + File.separator + "LogoSimple.png"));
    setVisible(true);
    addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
        public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            formInternalFrameActivated(evt);
        }
        public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
        }
        public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
        }
        public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
        }
        public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
        }
        public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
        }
        public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
        }
    });

    jLabel3.setText("Tipo:");

    btn_limpar.setText("Limpar");
    btn_limpar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_limparActionPerformed(evt);
        }
    });

    btn_enviar.setText("Enviar");
    btn_enviar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_enviarActionPerformed(evt);
        }
    });

    jLabel1.setText("Descrição:");

    jLabel2.setText("Valor:");

    jLabel4.setText("Imagem:");

    lbl_icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    lbl_icon.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            lbl_iconMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(btn_limpar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btn_enviar)))
            .addContainerGap(38, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel1))
                        .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lbl_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(28, 28, 28)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_limpar)
                .addComponent(btn_enviar))
            .addContainerGap(27, Short.MAX_VALUE))
    );

    lbl_icon.getAccessibleContext().setAccessibleDescription("");

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        ProdutoControl controle = new ProdutoControl();
        preencherTipos();
    }//GEN-LAST:event_formInternalFrameActivated

    private void preencherTipos() {
        modelo = new DefaultComboBoxModel<>();
        for (TipoProdutoEnum tipo : TipoProdutoEnum.values()) {
            modelo.addElement(tipo);
        }
        cb_tipo.setModel(modelo);
        cb_tipo.setSelectedIndex(-1);
    }
    
    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        for (Object component : getContentPane().getComponents()) {
            if (component instanceof JTextField && ((JTextField)component).getText().length() == 0) {
                Messages.showInformation("Preencha todos os campos!");
                return;
            } else if (component instanceof JComboBox && ((JComboBox)component).getSelectedIndex() == -1) {
                Messages.showInformation("Selecione um tipo para o produto.");
                return;
            }
        }
        ProdutoControl temp = new ProdutoControl();
        if (temp.inserir(new Produto(txt_desc.getText(), Float.parseFloat(txt_valor.getText().replace(",", ".")), 
                            TipoProdutoEnum.valueOf(cb_tipo.getSelectedItem().toString()), lbl_icon.getText())));
            limparCampos();
    }//GEN-LAST:event_btn_enviarActionPerformed

    private void lbl_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_iconMouseClicked
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Apenas Imagens", "png", "jpeg", "jpg", "gif"));
        fc.setAcceptAllFileFilterUsed(false);
        int status = fc.showOpenDialog(null);
        if(status == JFileChooser.APPROVE_OPTION)
        try {
            File icone = fc.getSelectedFile();
            String caminho = System.getProperty("user.dir") + File.separator + "images" + File.separator;
            Files.copy(icone.toPath(), Paths.get(caminho + icone.getName()), REPLACE_EXISTING);
            ImageIcon icon = new ImageIcon(caminho + icone.getName());
            Image image = icon.getImage();
            Image newimage = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            lbl_icon.setIcon(new ImageIcon(newimage));
            lbl_icon.setText(icone.getName());
            pack();
        } catch (IOException ex) {
            Messages.showError("Erro ao copiar arquivo!" + ex.getMessage());
        }
    }//GEN-LAST:event_lbl_iconMouseClicked

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        MainView.abreForm(CadastroProdutoView.getInstance());
    }//GEN-LAST:event_btn_limparActionPerformed

    private void limparCampos() {
        for (Object component : getContentPane().getComponents()) {
            if (component instanceof JTextField)
                ((JTextField)component).setText("");
            else if (component instanceof JComboBox)
                ((JComboBox)component).setSelectedIndex(-1);
            
            lbl_icon.setIcon(null);
            lbl_icon.setText("");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_enviar;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JComboBox<TipoProdutoEnum> cb_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JTextField txt_desc;
    private javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables
}
