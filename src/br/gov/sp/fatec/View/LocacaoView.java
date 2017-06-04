/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.View;

import br.gov.sp.fatec.Control.CadastroControl;
import br.gov.sp.fatec.Model.Cadastro;
import br.gov.sp.fatec.Model.Hospede;
import br.gov.sp.fatec.Model.Quarto;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thiago
 */
public class LocacaoView extends javax.swing.JInternalFrame {
    private DefaultTableModel model;
    private DefaultTableModel modelReserva;
    private Hospede cliente;
    private static LocacaoView window;
    /**
     * Creates new form TestTable
     */
    
    public static LocacaoView getInstance() {
        if (window != null) {
            window.dispose();
            window = null;
        } 
            window = new LocacaoView();
        return window;
    }
    
    private LocacaoView() {
        initComponents();
        preencherComum();
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

        txtCpf = new javax.swing.JFormattedTextField();
        tabPane = new javax.swing.JTabbedPane();
        tabComum = new javax.swing.JScrollPane();
        tableLocacao = new javax.swing.JTable();
        tabReserva = new javax.swing.JScrollPane();
        tableLocRes = new javax.swing.JTable();
        btnOkComum = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Locação");
        setFrameIcon(new ImageIcon(System.getProperty("user.dir") + File.separator +
            "images" + File.separator + "LogoSimple.png"));
    setVisible(true);

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

    tableLocacao.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null}
        },
        new String [] {
            "Quarto", "Tipo", "Vlr Diaria", "Check-In", "Check-Out"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, Date.class, Date.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, false, true, true
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    tableLocacao.getTableHeader().setReorderingAllowed(false);
    tableLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableLocacaoMouseClicked(evt);
        }
    });
    tabComum.setViewportView(tableLocacao);

    tabPane.addTab("Comum", tabComum);

    tabReserva.addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentShown(java.awt.event.ComponentEvent evt) {
            tabReservaComponentShown(evt);
        }
    });

    tableLocRes.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Id", "Quarto", "Check-In", "Check-Out", "Seleção"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
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
    tableLocRes.getTableHeader().setReorderingAllowed(false);
    tabReserva.setViewportView(tableLocRes);
    if (tableLocRes.getColumnModel().getColumnCount() > 0) {
        tableLocRes.getColumnModel().getColumn(0).setResizable(false);
        tableLocRes.getColumnModel().getColumn(4).setResizable(false);
    }

    tabPane.addTab("Com reserva", tabReserva);

    btnOkComum.setText("Confirmar");
    btnOkComum.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnOkComumActionPerformed(evt);
        }
    });

    jLabel1.setText("Cpf do Hóspede: ");

    lblInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do Hóspede", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 12))); // NOI18N

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(btnOkComum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabPane)
                .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
        .addGroup(layout.createSequentialGroup()
            .addGap(219, 219, 219)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(274, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
            .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnOkComum))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    public void preencherComum(){
        model = (DefaultTableModel) tableLocacao.getModel();
        model.getDataVector().clear();
        CadastroControl control = new CadastroControl();
        //"Quarto", "Tipo", "Vlr Diaria", "Check-In", "Check-Out"
        Vector aux;
        List<Quarto> temp = control.listarQuartos();
        if (temp.isEmpty()) {
            Messages.showInformation("Não há quartos disponíveis no momento!");
            return;
        }
        for (Quarto quarto : temp) {
            aux = new Vector();
            aux.add(quarto.getNumQuarto());
            aux.add(quarto.getTipoQuarto());
            aux.add(quarto.getValorDiaria());
            model.addRow(aux);
        }
    }
    
    public void preencherReserva(){
        modelReserva = (DefaultTableModel) tableLocRes.getModel();
        modelReserva.getDataVector().clear();
        CadastroControl control = new CadastroControl();
        //"Quarto", "Tipo", "Vlr Diaria", "Check-In", "Check-Out"
        Vector aux;
        List<Cadastro> temp = control.listarReservas(cliente.getIdHospede());
        if (temp.isEmpty()) {
            Messages.showInformation("Nenhuma reserva encontrada!");
            return;
        }
        for (Cadastro cadastro : temp) {
            aux = new Vector();
            aux.add(cadastro.getId());
            aux.add(cadastro.getNumQuarto());
            aux.add(cadastro.getDataCheckIn());
            aux.add(cadastro.getDataCheckOut());
            modelReserva.addRow(aux);
        }
    }
    
    private void tableLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLocacaoMouseClicked
        int row = tableLocacao.rowAtPoint(evt.getPoint());
        int col = tableLocacao.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 3) {
            if (col == 4){
                Object temp = tableLocacao.getValueAt(row, 3);
                if (temp == null) {
                    Messages.showInformation("Favor inserir data de check-in.");
                    return;
                }
                MainView.abreForm(DatePick.getInstance(tableLocacao, row, col, (Date)temp));
                return;
            }
            Object temp = tableLocacao.getValueAt(row, 4);
            if (temp != null)
                tableLocacao.setValueAt(null, row, 4);
            MainView.abreForm(DatePick.getInstance(tableLocacao, row, col, new Date()));
        }
    }//GEN-LAST:event_tableLocacaoMouseClicked

    private void btnOkComumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkComumActionPerformed
        CadastroControl control = new CadastroControl();
        boolean selected = false;
        if(tabPane.getSelectedIndex() == 0) {
            for (int i = 0; i < tableLocacao.getRowCount(); i++) {
                if (tableLocacao.getValueAt(i, 4) != null) {
                    control.realizarCadastro( 
                            (Integer) tableLocacao.getValueAt(i, 0),
                            cliente.getIdHospede(),
                            new java.sql.Date(((Date) tableLocacao.getValueAt(i, 3)).getTime()), 
                            new java.sql.Date(((Date) tableLocacao.getValueAt(i, 4)).getTime()),
                            MainView.funcionarioLogado.getId(),
                            "Locacao");
                            selected = true;
                            
                }
            }
            preencherComum();
        } else {
            for (int i = 0; i < tableLocRes.getRowCount(); i++) {
                if(tableLocRes.getValueAt(i, 4) != null && ((boolean)tableLocRes.getValueAt(i, 4)) == true) {
                    control.realizarLocacaoReserva(new Cadastro((Integer) tableLocRes.getValueAt(i, 0), "Locacao"));
                    selected = true;
                }
            }
            preencherReserva();
        }
            if(selected)
                Messages.showInformation("Locações realizadas!");
            else
                Messages.showError("Selecione ao menos um quarto!");
    }//GEN-LAST:event_btnOkComumActionPerformed

    private void txtCpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCpfMouseClicked
        txtCpf.setText("");
        txtCpf.setValue(null);
        if (modelReserva != null)
                modelReserva.getDataVector().clear();
        togglePanes(false);
        lblInfo.setText("");
    }//GEN-LAST:event_txtCpfMouseClicked

    private void togglePanes(boolean state) {
        tableLocacao.setVisible(state);
        tableLocRes.setVisible(state);
        tabPane.setEnabled(state);
        btnOkComum.setEnabled(state);
    }
    
    private void txtCpfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtCpfPropertyChange
        if (txtCpf.getText().contains(" ")) 
            return;
        CadastroControl control = new CadastroControl();
        cliente = control.verificaHospede(new Hospede(txtCpf.getText()));
        if (cliente == null) {
            Messages.showInformation("Hóspede não cadastrado!");
            return;
        }
        lblInfo.setText(cliente.toString());
        togglePanes(true);
    }//GEN-LAST:event_txtCpfPropertyChange

    private void tabReservaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabReservaComponentShown
        preencherReserva();
    }//GEN-LAST:event_tabReservaComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOkComum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JScrollPane tabComum;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JScrollPane tabReserva;
    private javax.swing.JTable tableLocRes;
    private javax.swing.JTable tableLocacao;
    private javax.swing.JFormattedTextField txtCpf;
    // End of variables declaration//GEN-END:variables
}
