/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.View;

import br.gov.sp.fatec.ServicosTecnicos.Persistencia.ProdutoDAO;
import br.gov.sp.fatec.Model.ItemMenu;
import br.gov.sp.fatec.Model.Produto;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.DefaultListModel;
import java.util.*;
import javafx.scene.control.Spinner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thiago
 */
public class ProdutoView extends javax.swing.JInternalFrame {
    public static DefaultTableModel model;
    private static ProdutoView window;
    /**
     * Creates new form Test
     */
    
    public static ProdutoView getInstance() {
        if (window != null) {
            window.dispose();
            window = null;
        } 
            window = new ProdutoView();
        return window;
    }
    
    private ProdutoView() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pannelProdutos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbConsumo = new javax.swing.JTable();
        btnDel = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consumo");
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

    pannelProdutos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    tbConsumo.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Produto", "Valor", "Quantidade", "Seleção"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
        };
        boolean[] canEdit = new boolean [] {
            false, true, false, true
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    tbConsumo.getTableHeader().setReorderingAllowed(false);
    jScrollPane2.setViewportView(tbConsumo);

    pannelProdutos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 730, 230));

    btnDel.setText("Excluir Item(s)");
    btnDel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDelActionPerformed(evt);
        }
    });
    pannelProdutos.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 360, -1));

    btnOk.setText("Comfirmar");
    pannelProdutos.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 370, -1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pannelProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pannelProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        model = (DefaultTableModel) tbConsumo.getModel();
        ProdutoDAO canal = new ProdutoDAO();
        List<Produto> produtos = new ArrayList<>();
        int offset = 10;
        try {
            produtos = canal.listar("");
        } catch (SQLException ex) {
            Messages.showError("Erro ao listar produtos: " + ex.getMessage());
        }
        for (Produto produto : produtos) {
            JSpinner numPick = new JSpinner();
            numPick.setModel(new SpinnerNumberModel(1, 1, 99, 1));
            pannelProdutos.add(numPick, new org.netbeans.lib.awtextra.AbsoluteConstraints(offset + 33, 103, 50, -1));
            pannelProdutos.add(new ItemMenu(produto, new Point(offset, 20), numPick), new org.netbeans.lib.awtextra.AbsoluteConstraints(offset, 20, -1, -1));
            pannelProdutos.add(new javax.swing.JLabel(NumberFormat.getCurrencyInstance().format(produto.getValor())), 
                               new org.netbeans.lib.awtextra.AbsoluteConstraints(offset, 5, -1, -1));
            offset += 80;
        }
        pannelProdutos.setComponentZOrder(jScrollPane2, pannelProdutos.getComponentCount() -1);
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Excluir apenas items selecionados?", "Selecione uma opção", JOptionPane.YES_NO_CANCEL_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            for (int i = model.getRowCount() - 1; i >= 0 ; i--) {
                if (tbConsumo.getValueAt(i, 3) != null && (boolean) tbConsumo.getValueAt(i, 3) == true)
                    model.removeRow(i);
            }
        } else if (result == JOptionPane.NO_OPTION) {
            model.getDataVector().clear();
            model.fireTableDataChanged();
        }
    }//GEN-LAST:event_btnDelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnOk;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pannelProdutos;
    private javax.swing.JTable tbConsumo;
    // End of variables declaration//GEN-END:variables
}
