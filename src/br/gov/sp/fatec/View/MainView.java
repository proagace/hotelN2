/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.View;

import br.gov.sp.fatec.Control.AtualizaDiariasControl;
import br.gov.sp.fatec.Model.Usuario;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class MainView extends javax.swing.JFrame {
    private boolean stateMenus = false;
    public static Usuario funcionarioLogado;
    public static final boolean debug = false;
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
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
            Image newimage = new ImageIcon(System.getProperty("user.dir") + File.separator +
                "images" + File.separator + "background.png").getImage();
            //resize
            //Image newimage = image.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(newimage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuProdutos = new javax.swing.JMenuItem();
        menuHospedes = new javax.swing.JMenuItem();
        menuTeste = new javax.swing.JMenu();
        test1 = new javax.swing.JMenuItem();
        menuLocacao = new javax.swing.JMenuItem();
        menuReserva = new javax.swing.JMenuItem();
        Estadia = new javax.swing.JMenuItem();
        menuDiarias = new javax.swing.JMenu();
        pagamento = new javax.swing.JMenuItem();
        menuConsulta = new javax.swing.JMenu();
        Hospede = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        Logout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VendraHotel");
        setIconImage(new ImageIcon(System.getProperty("user.dir") + File.separator +
            "images" + File.separator + "LogoSimple.png").getImage());
    addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowOpened(java.awt.event.WindowEvent evt) {
            formWindowOpened(evt);
        }
    });

    mainContainer.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            mainContainerMouseClicked(evt);
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
        .addGap(0, 500, Short.MAX_VALUE)
    );

    menuCadastro.setMnemonic('c');
    menuCadastro.setText("Cadastro");

    menuProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
    menuProdutos.setText("Produtos");
    menuProdutos.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuProdutosActionPerformed(evt);
        }
    });
    menuCadastro.add(menuProdutos);

    menuHospedes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
    menuHospedes.setText("Hóspedes");
    menuHospedes.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuHospedesActionPerformed(evt);
        }
    });
    menuCadastro.add(menuHospedes);

    jMenuBar1.add(menuCadastro);

    menuTeste.setMnemonic('t');
    menuTeste.setText("Teste");

    test1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
    test1.setText("TesteProdutos");
    test1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            test1ActionPerformed(evt);
        }
    });
    menuTeste.add(test1);

    menuLocacao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
    menuLocacao.setText("Locação");
    menuLocacao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuLocacaoActionPerformed(evt);
        }
    });
    menuTeste.add(menuLocacao);

    menuReserva.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
    menuReserva.setText("Reserva");
    menuReserva.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuReservaActionPerformed(evt);
        }
    });
    menuTeste.add(menuReserva);

    Estadia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
    Estadia.setText("Encerrar Estadia");
    Estadia.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            EstadiaActionPerformed(evt);
        }
    });
    menuTeste.add(Estadia);

    jMenuBar1.add(menuTeste);

    menuDiarias.setMnemonic('d');
    menuDiarias.setText("Diárias");

    pagamento.setText("Pagamento");
    pagamento.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            pagamentoActionPerformed(evt);
        }
    });
    menuDiarias.add(pagamento);

    jMenuBar1.add(menuDiarias);

    menuConsulta.setText("Consulta");

    Hospede.setText("Hóspedes");
    Hospede.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            HospedeActionPerformed(evt);
        }
    });
    menuConsulta.add(Hospede);

    jMenuBar1.add(menuConsulta);

    menuSair.setText("Sair");

    Logout.setText("Logout");
    Logout.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            LogoutActionPerformed(evt);
        }
    });
    menuSair.add(Logout);

    jMenuBar1.add(Box.createHorizontalGlue());

    jMenuBar1.add(menuSair);

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
        abreForm(CadastroProdutoView.getInstance());
    }//GEN-LAST:event_menuProdutosActionPerformed
  
    public void toggleMenus() {
        int n = jMenuBar1.getMenuCount();
        for (int i = 0; i < n; i++) {
            if (jMenuBar1.getMenu(i) != null)
                jMenuBar1.getMenu(i).setEnabled(stateMenus);
        }
        stateMenus = !stateMenus;
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        AtualizaDiariasControl ctrl = new AtualizaDiariasControl();
        ctrl.atualizar();
        mainContainer.add(new NotificacaoView());
        if (debug)
            return;
        toggleMenus();
        abreForm(new LoginView(this));
    }//GEN-LAST:event_formWindowOpened
   
    private void test1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test1ActionPerformed
        abreForm(ProdutoView.getInstance());
    }//GEN-LAST:event_test1ActionPerformed

    private void pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagamentoActionPerformed
        abreForm(PagamentoView.getInstance());
    }//GEN-LAST:event_pagamentoActionPerformed

    private void menuHospedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHospedesActionPerformed
        abreForm(CadastroHospedeView.getInstance());
    }//GEN-LAST:event_menuHospedesActionPerformed

    private void mainContainerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainContainerMouseClicked
        if (evt.isControlDown())
            mainContainer.add(TestMenuMouse.getInstance(evt.getPoint()));
    }//GEN-LAST:event_mainContainerMouseClicked

    private void menuLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLocacaoActionPerformed
        abreForm(LocacaoView.getInstance());
    }//GEN-LAST:event_menuLocacaoActionPerformed

    private void menuReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReservaActionPerformed
        abreForm(ReservaView.getInstance());
    }//GEN-LAST:event_menuReservaActionPerformed

    private void HospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HospedeActionPerformed
        abreForm(ConsultaHospedeView.getInstance());
    }//GEN-LAST:event_HospedeActionPerformed

    private void EstadiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadiaActionPerformed
        abreForm(EncerraEstadiaView.getInstance());
    }//GEN-LAST:event_EstadiaActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        toggleMenus();
        abreForm(new LoginView(this));
    }//GEN-LAST:event_LogoutActionPerformed

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
        
        Runnable update = new Runnable() {
            public void run() {
                NotificacaoView.preencherTable();
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                update.run();
            }
        }, System.currentTimeMillis() % 60000, 60000);
    }

    public static void abreForm (JInternalFrame window) {
        for (Component component : mainContainer.getComponents()) {
            if (component.equals(window))
                return;
        }
        window.setLocation(new Point((mainContainer.getWidth() - window.getWidth())/2, 
                                (mainContainer.getHeight() - window.getHeight())/2));
        mainContainer.add(window);
        window.setVisible(true);
        try {
            window.setSelected(true);
        } catch (PropertyVetoException ex) {
            Messages.showError("Erro ao adquirir foco: " + ex.getMessage());
        }
    }
    
    public static void removeForm (JInternalFrame window) {
        window.setVisible(false);
        mainContainer.remove(window);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Estadia;
    private javax.swing.JMenuItem Hospede;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JMenuBar jMenuBar1;
    private static javax.swing.JDesktopPane mainContainer;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuConsulta;
    private javax.swing.JMenu menuDiarias;
    private javax.swing.JMenuItem menuHospedes;
    private javax.swing.JMenuItem menuLocacao;
    private javax.swing.JMenuItem menuProdutos;
    private javax.swing.JMenuItem menuReserva;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenu menuTeste;
    private javax.swing.JMenuItem pagamento;
    private javax.swing.JMenuItem test1;
    // End of variables declaration//GEN-END:variables
}
