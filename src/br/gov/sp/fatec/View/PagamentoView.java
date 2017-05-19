/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.View;

import br.gov.sp.fatec.Control.PagamentoControl;
import br.gov.sp.fatec.Model.Diaria;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thiago
 */
public class PagamentoView extends javax.swing.JInternalFrame {

    /**
     * Creates new form PagamentoView
     */
    public PagamentoView() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbConsulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pagamentos");
        setVisible(true);

        tbConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Id Locação", "Data", "Valor R$"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.util.Date.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbConsulta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbConsulta);
        if (tbConsulta.getColumnModel().getColumnCount() > 0) {
            tbConsulta.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbConsulta.getColumnModel().getColumn(1).setPreferredWidth(10);
            tbConsulta.getColumnModel().getColumn(2).setPreferredWidth(50);
            tbConsulta.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        jLabel1.setText("Cpf do Hóspede: ");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtCpf.getText().length() == 0) {
            Messages.showInformation("Preencha o campo Cpf para realizar busca!");
            return;
        }
        preencherTable();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void preencherTable() {
        DefaultTableModel model;
        model = (DefaultTableModel) tbConsulta.getModel();
        PagamentoControl control = new PagamentoControl();
        Vector col;
        model.getDataVector().clear();
        for (Diaria diaria : control.listar(Integer.parseInt(txtCpf.getText()))) {
            col = new Vector();
            col.add(diaria.getCod());
            col.add(diaria.getIdLocacao());
            col.add(diaria.getReferente());
            col.add(diaria.getValor());
            model.addRow(col);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbConsulta;
    private javax.swing.JTextField txtCpf;
    // End of variables declaration//GEN-END:variables
}
