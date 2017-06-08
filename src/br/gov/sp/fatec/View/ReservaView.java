/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.View;

import br.gov.sp.fatec.ServicosTecnicos.Persistencia.QuartoDAO;
import br.gov.sp.fatec.Control.CadastroControl;
import br.gov.sp.fatec.Model.Cadastro;
import br.gov.sp.fatec.Model.Hospede;
import br.gov.sp.fatec.Model.Quarto;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import java.io.File;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Thiago
 */
public class ReservaView extends javax.swing.JInternalFrame {
    private DefaultTableModel modelReserva;
    private Hospede cliente;
    private String tipoCadastro;
    private static ReservaView window;
    
    /**
     * Creates new form Test
     */
    public static ReservaView getInstance() {
        if (window != null) {
            window.dispose();
            window = null;
        } 
            window = new ReservaView();
        return window;
    }    

    public ReservaView() {
        initComponents();
        preencherTbQuarto();
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

        tabCadastro = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableQuarto = new javax.swing.JTable();
        tabReserva = new javax.swing.JScrollPane();
        tableCancel = new javax.swing.JTable();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        btnReserva = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();

        setClosable(true);
        setFrameIcon(new ImageIcon(System.getProperty("user.dir") + File.separator +
            "images" + File.separator + "LogoSimple.png"));
    setVisible(true);

    tableQuarto.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Numero", "Tipo", "Valor Diária", "Data Check-In", "Data Check-Out"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, Date.class, Date.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    tableQuarto.getTableHeader().setReorderingAllowed(false);
    tableQuarto.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableQuartoMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(tableQuarto);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
            .addContainerGap())
    );

    tabCadastro.addTab("Reserva", jPanel1);

    tabReserva.addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentShown(java.awt.event.ComponentEvent evt) {
            tabReservaComponentShown(evt);
        }
    });

    tableCancel.setModel(new javax.swing.table.DefaultTableModel(
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
    tableCancel.getTableHeader().setReorderingAllowed(false);
    tabReserva.setViewportView(tableCancel);

    tabCadastro.addTab("Cancelamento", tabReserva);

    try {
        txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }
    txtCpf.setText("");
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

    jLabel4.setText("CPF Hóspede");

    btnReserva.setText("Confirmar");
    btnReserva.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnReservaActionPerformed(evt);
        }
    });

    lblInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do Hóspede", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 12))); // NOI18N

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btnReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
        .addGroup(layout.createSequentialGroup()
            .addGap(143, 143, 143)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
        .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(tabCadastro))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(tabCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limparCampos(){
        txtCpf.setText("");
        txtCpf.setValue(null);
        lblInfo.setText("");
        tableQuarto.getSelectionModel().clearSelection();
        if (modelReserva != null)
                modelReserva.getDataVector().clear();        
        togglePanes(false);
    }
    
    private void txtCpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCpfMouseClicked
        limparCampos();
    }//GEN-LAST:event_txtCpfMouseClicked
    
    private void togglePanes(boolean state) {
        tableQuarto.setVisible(state);
        //tableLocRes.setVisible(state);
        tabCadastro.setEnabled(state);
        btnReserva.setEnabled(state);
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

    private void btnReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservaActionPerformed
        CadastroControl control = new CadastroControl();
        tipoCadastro = "Reserva";
        boolean selection = false;
        
        //
        if(tabCadastro.getSelectedIndex() == 0){
            for (int linha = 0; linha < tableQuarto.getRowCount(); linha++) {
                if(tableQuarto.getValueAt(linha, 4) != null){
                    String numQuarto = tableQuarto.getValueAt(linha, 0).toString();
                    java.sql.Date checkIn = new java.sql.Date(((Date)tableQuarto.getValueAt(linha, 3)).getTime());
                    java.sql.Date checkOut = new java.sql.Date(((Date)tableQuarto.getValueAt(linha, 4)).getTime());
                    control.realizarCadastro(Integer.parseInt(numQuarto), cliente.getIdHospede(), checkIn, checkOut, MainView.funcionarioLogado.getId(), tipoCadastro);
                    Messages.showInformation("Reserva realizada.");
                    selection = true;
                }
            }
            preencherReserva();
        }else{ //Cancelamento
            for (int i = 0; i < tableCancel.getRowCount(); i++) {
                if(tableCancel.getValueAt(i, 4) != null && ((boolean)tableCancel.getValueAt(i, 4)) == true) {
                    control.cancelaReserva(new Cadastro((Integer) tableCancel.getValueAt(i, 0)), ((int)tableCancel.getValueAt(i, 1)));
                    Messages.showInformation("Cancelamento realizado.");                    
                    selection = true;
                }
            }            
            preencherTbQuarto();
        }
        if(!selection)
            Messages.showError("Selecione pelo menos um quarto");
    }//GEN-LAST:event_btnReservaActionPerformed

    private void tableQuartoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableQuartoMouseClicked
        int row = tableQuarto.rowAtPoint(evt.getPoint());
        int col = tableQuarto.columnAtPoint(evt.getPoint());
        if (row >= 0) {
            if(tableQuarto.getColumnName(col).equals("Data Check-In")){
                Object temp = tableQuarto.getValueAt(row, col + 1);
                if (temp != null)
                    tableQuarto.setValueAt(null, row, col + 1);
                MainView.abreForm(new DatePick(tableQuarto, row, col, new Date()));
            }
            if(tableQuarto.getColumnName(col).equals("Data Check-Out")){
                Object temp = tableQuarto.getValueAt(row, col -1);
                if (temp == null) {
                    Messages.showInformation("Favor inserir data de check-in.");
                    return;
                }
                MainView.abreForm(new DatePick(tableQuarto, row, col, (Date)temp));
            }
        }
    }//GEN-LAST:event_tableQuartoMouseClicked

    public void preencherReserva(){
        modelReserva = (DefaultTableModel) tableCancel.getModel();
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
    
    private void tabReservaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabReservaComponentShown
        preencherReserva();
    }//GEN-LAST:event_tabReservaComponentShown

    public void preencherTbQuarto(){
        DefaultTableModel tmodel = (DefaultTableModel) tableQuarto.getModel();
        
        CadastroControl control = new CadastroControl();
        tmodel.setRowCount(0);
        for (Quarto quarto : control.listarQuartos()){
            tmodel.addRow(new Object[]{
                quarto.getNumQuarto(),
                quarto.getTipoQuarto(),
                NumberFormat.getCurrencyInstance().format(quarto.getValorDiaria())
            });
        }
        tableQuarto.setAutoCreateRowSorter(true);
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReserva;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JTabbedPane tabCadastro;
    private javax.swing.JScrollPane tabReserva;
    private javax.swing.JTable tableCancel;
    private javax.swing.JTable tableQuarto;
    private javax.swing.JFormattedTextField txtCpf;
    // End of variables declaration//GEN-END:variables
}
