/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.View;

import br.gov.sp.fatec.ServicosTecnicos.BancoFactory;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author Thiago
 */
public class MainView extends javax.swing.JFrame {
    private boolean stateMenus = false;
    private String usuarioLogado = "";
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        BancoFactory.abreBanco();
        BancoFactory.fechaBanco();
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainContainer = new javax.swing.JDesktopPane(){
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + File.separator +
                "images" + File.separator + "background.jpg");
            Image newimage = icon.getImage();
            //resize
            //Image newimage = image.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(newimage, 0, 0, this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuProdutos = new javax.swing.JMenuItem();
        menuTeste = new javax.swing.JMenu();
        test1 = new javax.swing.JMenuItem();
        test2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout mainContainerLayout = new javax.swing.GroupLayout(mainContainer);
        mainContainer.setLayout(mainContainerLayout);
        mainContainerLayout.setHorizontalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
        mainContainerLayout.setVerticalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );

        menuCadastro.setText("Cadastro");

        menuProdutos.setText("Produtos");
        menuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProdutosActionPerformed(evt);
            }
        });
        menuCadastro.add(menuProdutos);

        jMenuBar1.add(menuCadastro);

        menuTeste.setText("Teste");

        test1.setText("TesteProdutos");
        test1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test1ActionPerformed(evt);
            }
        });
        menuTeste.add(test1);

        test2.setText("TesteTable");
        test2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test2ActionPerformed(evt);
            }
        });
        menuTeste.add(test2);

        jMenuBar1.add(menuTeste);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainer)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainer)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProdutosActionPerformed
        try {
            mainContainer.getComponent(0).setVisible(false);
        } catch (Exception e) {
        } finally {
            mainContainer.removeAll();
            abreForm(new CadastroProdutoView());
        }  
    }//GEN-LAST:event_menuProdutosActionPerformed
  
    public void toggleMenus() {
        int n = jMenuBar1.getMenuCount();
        for (int i = 0; i < n; i++) {
            jMenuBar1.getMenu(i).setEnabled(stateMenus);
        }
        stateMenus = !stateMenus;
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        toggleMenus();
        abreForm(new LoginView(this));
    }//GEN-LAST:event_formWindowOpened
   
    private void test1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test1ActionPerformed
        try {
            mainContainer.getComponent(0).setVisible(false);
        } catch (Exception e) {
        } finally {
            Test.model.clear();
            mainContainer.removeAll();
            abreForm(new Test());
        }
    }//GEN-LAST:event_test1ActionPerformed

    private void test2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test2ActionPerformed
        abreForm(new TestTable());
    }//GEN-LAST:event_test2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public static void abreForm (JInternalFrame window) {
        window.setLocation(new Point((mainContainer.getWidth() - window.getWidth())/2, 
                                (mainContainer.getHeight() - window.getHeight())/2));
        mainContainer.add(window);
        try {
            window.setSelected(true);
        } catch (PropertyVetoException ex) {
            Messages.showError("Erro ao adquirir foco: " + ex.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private static javax.swing.JDesktopPane mainContainer;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuProdutos;
    private javax.swing.JMenu menuTeste;
    private javax.swing.JMenuItem test1;
    private javax.swing.JMenuItem test2;
    // End of variables declaration//GEN-END:variables
}
