/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.View;

import br.gov.sp.fatec.Control.CadastroControl;
import br.gov.sp.fatec.Control.ProdutoControl;
import br.gov.sp.fatec.Control.SolicitacaoControl;
import br.gov.sp.fatec.Model.Cadastro;
import br.gov.sp.fatec.Model.Hospede;
import br.gov.sp.fatec.ServicosTecnicos.Persistencia.ProdutoDAO;
import br.gov.sp.fatec.Model.ItemMenu;
import br.gov.sp.fatec.Model.Produto;
import br.gov.sp.fatec.Model.TotalConsumo;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.DefaultListModel;
import java.util.*;
import javafx.scene.control.Spinner;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
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
    private Hospede cliente;
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
        togglePanes(false);
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
        lblInfo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        cmbQuarto = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

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
            "Código do Produto", "Produto", "Valor", "Quantidade", "Seleção"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, false, false, true
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

    pannelProdutos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 810, 230));

    btnDel.setText("Excluir Item(s)");
    btnDel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDelActionPerformed(evt);
        }
    });
    pannelProdutos.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 390, -1));

    btnOk.setText("Confirmar");
    btnOk.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnOkActionPerformed(evt);
        }
    });
    pannelProdutos.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 420, -1));

    lblInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do Hóspede", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 12))); // NOI18N

    jLabel1.setText("Cpf do Hóspede: ");

    try {
        txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }
    txtCpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txtCpf.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
    txtCpf.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            txtCpfMouseClicked(evt);
        }
    });
    txtCpf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            txtCpfPropertyChange(evt);
        }
    });

    jLabel2.setText("Quarto:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(lblInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(pannelProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
        .addGroup(layout.createSequentialGroup()
            .addGap(135, 135, 135)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cmbQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cmbQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pannelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        String[] opt = {"Excluir todos os itens.", "Excluir apenas selecionados.", "Cancelar"};
        int result = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Exclusão de Itens", 0, JOptionPane.INFORMATION_MESSAGE, null, opt, null);
        if (result == 0) {
            model.getDataVector().clear();
            model.fireTableDataChanged();
        } else if (result == 1) {
            for (int i = model.getRowCount() - 1; i >= 0 ; i--) {
                if (tbConsumo.getValueAt(i, 4) != null && (boolean) tbConsumo.getValueAt(i, 4) == true)
                    model.removeRow(i);
            }
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        SolicitacaoControl ctrlSol = new SolicitacaoControl();
        Cadastro cad = ctrlSol.buscaCadastro(txtCpf.getText(), (int) cmbQuarto.getSelectedItem());
        
        if(cad == null)
            return;
        for (int i = 0; i < tbConsumo.getRowCount(); i++) {
            ctrlSol.solicitaProduto(new TotalConsumo(cad.getId(), (int) tbConsumo.getValueAt(i, 0), (int) tbConsumo.getValueAt(i, 3), false));
        }
        Messages.show("Produtos solicitados com sucesso.");
        MainView.abreForm(ProdutoView.getInstance());
    }//GEN-LAST:event_btnOkActionPerformed

    private void togglePanes(boolean state) {
        tbConsumo.setVisible(state);
        btnOk.setEnabled(state);
        btnDel.setEnabled(state);
        cmbQuarto.setEnabled(state);
    }    
    
    private void txtCpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCpfMouseClicked
        txtCpf.setText("");
        txtCpf.setValue(null);
        if (model != null)
            model.getDataVector().clear();
        togglePanes(false);
        cmbQuarto.removeAllItems();
        lblInfo.setText("");
    }//GEN-LAST:event_txtCpfMouseClicked

    private void txtCpfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtCpfPropertyChange
        if (txtCpf.getText().contains(" "))
            return;
        CadastroControl control = new CadastroControl();
        SolicitacaoControl scontrol = new SolicitacaoControl();
        cliente = control.verificaHospede(new Hospede(txtCpf.getText()));
        if (cliente == null) {
            Messages.showInformation("Hóspede não cadastrado!");
            txtCpf.setText("");            
            return;
        }
        scontrol.buscaQuarto(txtCpf.getText(), (DefaultComboBoxModel) cmbQuarto.getModel());
        lblInfo.setText(cliente.toString());
        if(cmbQuarto.getItemCount() == 0)
            return;
        togglePanes(true);
    }//GEN-LAST:event_txtCpfPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnOk;
    private javax.swing.JComboBox<Integer> cmbQuarto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JPanel pannelProdutos;
    private javax.swing.JTable tbConsumo;
    private javax.swing.JFormattedTextField txtCpf;
    // End of variables declaration//GEN-END:variables
}
