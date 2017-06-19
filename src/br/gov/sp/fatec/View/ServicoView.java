/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.View;

import br.gov.sp.fatec.Control.CadastroControl;
import br.gov.sp.fatec.Control.ProdutoControl;
import br.gov.sp.fatec.Control.ServicoControl;
import br.gov.sp.fatec.Control.SolicitacaoControl;
import br.gov.sp.fatec.Model.Cadastro;
import br.gov.sp.fatec.Model.Hospede;
import br.gov.sp.fatec.Model.Servico;
import br.gov.sp.fatec.Model.TotalServico;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import javax.swing.ImageIcon;
import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexandre
 */
public class ServicoView extends javax.swing.JInternalFrame {
    private Hospede cliente;
    private static ServicoView window;
    /**
     * Creates new form ServicoView
     */

    
    public static ServicoView getInstance() {
        if (window != null) {
            window.dispose();
            window = null;
        } 
            window = new ServicoView();
        return window;
    }
    
    public ServicoView() {
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

        lblInfo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbServico = new javax.swing.JTable();
        btnConfirma = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbQuarto = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Solicitação de Serviços");
        setFrameIcon(new ImageIcon(System.getProperty("user.dir") + File.separator +
            "images" + File.separator + "LogoSimple.png"));

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

    tbServico.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Código do Serviço", "Serviço", "Tipo", "Valor", "Seleção"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
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
    jScrollPane1.setViewportView(tbServico);

    btnConfirma.setText("Confirmar");
    btnConfirma.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnConfirmaActionPerformed(evt);
        }
    });

    jLabel2.setText("Quarto:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jScrollPane1)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(115, 115, 115)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cmbQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2)
                .addComponent(cmbQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(6, 6, 6)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnConfirma)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void togglePanes(boolean state) {
        tbServico.setEnabled(state);
        btnConfirma.setEnabled(state);
        cmbQuarto.setEnabled(state);
        
    }      
    
    private void txtCpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCpfMouseClicked
        txtCpf.setText("");
        txtCpf.setValue(null);
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
        preencherServico();        
    }//GEN-LAST:event_txtCpfPropertyChange

    private void btnConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaActionPerformed
        SolicitacaoControl ctrlSol = new SolicitacaoControl();
        Cadastro cad = ctrlSol.buscaCadastro(txtCpf.getText(), (int) cmbQuarto.getSelectedItem());
        java.sql.Date dataAtual = new java.sql.Date(new Date().getTime());
        float valor;
        if(cad == null)
            return;
        for (int i = 0; i < tbServico.getRowCount(); i++) {
            if(tbServico.getValueAt(i, 4) != null && ((boolean)tbServico.getValueAt(i, 4)) == true) {
                ctrlSol.solicitaServico(new TotalServico(cad.getId(), (int)tbServico.getValueAt(i, 0), dataAtual, false));
            }
        }
        Messages.show("Serviços solicitados com sucesso.");
        MainView.abreForm(ServicoView.getInstance());        
    }//GEN-LAST:event_btnConfirmaActionPerformed
    
    private void preencherServico(){
        DefaultTableModel model = (DefaultTableModel) tbServico.getModel();
        model.getDataVector().clear();
        ServicoControl controlserv = new ServicoControl();
        
        for (Servico servico : controlserv.listaServico()) {
            model.addRow(new Object[]{
                servico.getIdServico(),
                servico.getDescricao(),
                servico.getTipo(),
                NumberFormat.getCurrencyInstance().format(servico.getValor())
            });
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirma;
    private javax.swing.JComboBox<Integer> cmbQuarto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JTable tbServico;
    private javax.swing.JFormattedTextField txtCpf;
    // End of variables declaration//GEN-END:variables
}