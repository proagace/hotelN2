package br.gov.sp.fatec.View;

import br.gov.sp.fatec.Control.PagamentoControl;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandre
 */
public class CartaoView extends javax.swing.JInternalFrame {
    public static CartaoView window;
    private float valor;
    private JTable tbDiaria, tbServico, tbConsumo;
    /**
     * Creates new form CartaoView
     * @param tbDiaria
     * @param tbServico
     * @param tbConsumo
     * @return 
     */
    public static CartaoView getInstance(JTable tbDiaria, JTable tbServico, JTable tbConsumo) {
        if (window != null) {
            window.dispose();
            window = null;
        } 
            window = new CartaoView(tbDiaria, tbServico, tbConsumo);
        return window;
    }
    public CartaoView(JTable tbDiaria, JTable tbServico, JTable tbConsumo){
        initComponents();
        this.tbDiaria = tbDiaria;
        this.tbConsumo = tbConsumo;
        this.tbServico = tbServico;
        parcelamento(calculaTotal());
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneCartao = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtCpfCartao = new javax.swing.JFormattedTextField();
        cmbPagto = new javax.swing.JComboBox<>();
        cmbValMes = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbValAno = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodSeg = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNum = new javax.swing.JFormattedTextField();
        txtNome = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dtcDataNasc = new com.toedter.calendar.JDateChooser();
        btnConfirma = new javax.swing.JButton();

        setClosable(true);
        setFrameIcon(new ImageIcon(System.getProperty("user.dir") + File.separator +
            "images" + File.separator + "LogoSimple.png"));
    setVisible(true);

    jLabel5.setText("Número do Cartão");

    try {
        txtCpfCartao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }
    txtCpfCartao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txtCpfCartao.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

    cmbValMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
    cmbValMes.setSelectedIndex(-1);

    jLabel6.setText("Validade (mm/aa)");

    cmbValAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "17", "18", "19", "20", "21", "22", "23", "24", "25" }));
    cmbValAno.setSelectedIndex(-1);

    jLabel7.setText("Código de Segurança");

    jLabel8.setText("CPF");

    jLabel3.setText("Forma de Pagamento");

    jLabel4.setText("Nome");

    try {
        txtCodSeg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }

    jLabel10.setText("Dados do Cartão / Titular do Cartão");

    try {
        txtNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### #### ####")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }

    jLabel9.setText("Data de Nascimento");

    javax.swing.GroupLayout paneCartaoLayout = new javax.swing.GroupLayout(paneCartao);
    paneCartao.setLayout(paneCartaoLayout);
    paneCartaoLayout.setHorizontalGroup(
        paneCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(paneCartaoLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(paneCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneCartaoLayout.createSequentialGroup()
                    .addGroup(paneCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addGroup(paneCartaoLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCodSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(paneCartaoLayout.createSequentialGroup()
                    .addGroup(paneCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(paneCartaoLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbPagto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel8)
                        .addGroup(paneCartaoLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(98, 98, 98)
                            .addComponent(txtNome))
                        .addGroup(paneCartaoLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addGroup(paneCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCpfCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(paneCartaoLayout.createSequentialGroup()
                                    .addComponent(cmbValMes, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbValAno, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(dtcDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(87, Short.MAX_VALUE))))
        .addGroup(paneCartaoLayout.createSequentialGroup()
            .addGap(125, 125, 125)
            .addComponent(jLabel10)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    paneCartaoLayout.setVerticalGroup(
        paneCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneCartaoLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel10)
            .addGap(18, 18, 18)
            .addGroup(paneCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3)
                .addComponent(cmbPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(paneCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(paneCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel9)
                .addComponent(dtcDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(paneCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtCpfCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(paneCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(paneCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(cmbValMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cmbValAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(paneCartaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtCodSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel7))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    btnConfirma.setText("Confirmar");
    btnConfirma.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnConfirmaActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(btnConfirma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createSequentialGroup()
            .addGap(95, 95, 95)
            .addComponent(paneCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(100, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addComponent(paneCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnConfirma)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void parcelamento(float valor){
        float temp;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        cmbPagto.removeAllItems();
        for (int i = 1; i <= 10; i++) {
            temp = valor/i;
            cmbPagto.addItem(""+i+"x "+"sem juros - R$"+df.format(temp)+"");        
        }   
    }    
    
    private float calculaTotal(){
        float subTotal = 0;
        
        for (int i = 0; i < tbDiaria.getRowCount(); i++) {
            if(tbDiaria.getValueAt(i, 3) != null && ((boolean)tbDiaria.getValueAt(i, 3)) == true) {
                subTotal += converte(tbDiaria.getValueAt(i, 2));
            }
         }
        for (int i = 0; i < tbServico.getRowCount(); i++) {
            if(tbServico.getValueAt(i, 2) != null && ((boolean)tbServico.getValueAt(i, 2)) == true) {
                subTotal += converte(tbServico.getValueAt(i, 1));
            }
         }
        for (int i = 0; i < tbConsumo.getRowCount(); i++) {
            if(tbConsumo.getValueAt(i, 2) != null && ((boolean)tbConsumo.getValueAt(i, 2)) == true) {
                subTotal += converte(tbConsumo.getValueAt(i, 1));
            }
         }
        return subTotal;
    }
    
    public float converte(Object campo){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        Number num = null;
        try {
            num = nf.parse((String) campo);
            return num.floatValue();  
        } catch (ParseException ex) {
            Messages.showError("Erro inesperado.");
        }
        return 0;
    }
    
    private void btnConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaActionPerformed
        PagamentoControl control = new PagamentoControl();
        boolean selected = false;
        
        for (Component component : paneCartao.getComponents()) {
            if(component instanceof JTextField && ((JTextField)component).getText().isEmpty()){
                Messages.showError("Preencha todos os campos corretamente!");
                return;
            }
            if(component instanceof JComboBox && ((JComboBox)component).getSelectedItem() == null){
                Messages.showError("Preencha todos os campos corretamente!");
                return;
            }
            if(component instanceof JFormattedTextField && ((JFormattedTextField)component).getText().isEmpty()){
                Messages.showError("Preencha todos os campos corretamente!");            
                return;
            }
            if(component instanceof JDateChooser && ((JDateChooser)component).getDate()==null){
                Messages.showError("Preencha todos os campos corretamente!");            
                return;
            }
        }
        
        for (int i = 0; i < tbDiaria.getRowCount(); i++) {
            if(tbDiaria.getValueAt(i, 3) != null && ((boolean)tbDiaria.getValueAt(i, 3)) == true) {
                control.pagtoDiaria((int) tbDiaria.getValueAt(i, 0));
                selected = true;
            }
         }
        for (int i = 0; i < tbServico.getRowCount(); i++) {
            if(tbServico.getValueAt(i, 2) != null && ((boolean)tbServico.getValueAt(i, 2)) == true) {
                control.pagtoServico((int) tbServico.getValueAt(i, 0));
                selected = true;                
            }
         }
        for (int i = 0; i < tbConsumo.getRowCount(); i++) {
            if(tbConsumo.getValueAt(i, 2) != null && ((boolean)tbConsumo.getValueAt(i, 2)) == true) {
                control.pagtoConsumo((int) tbConsumo.getValueAt(i, 0));
                selected = true;
            }
         }
        
        if(selected){
            Messages.show("Pagamento realizado com sucesso.");
            MainView.abreForm(PagamentoView.getInstance());
            window.dispose();
        }

    }//GEN-LAST:event_btnConfirmaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirma;
    private javax.swing.JComboBox<String> cmbPagto;
    private javax.swing.JComboBox<String> cmbValAno;
    private javax.swing.JComboBox<String> cmbValMes;
    private com.toedter.calendar.JDateChooser dtcDataNasc;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel paneCartao;
    private javax.swing.JFormattedTextField txtCodSeg;
    private javax.swing.JFormattedTextField txtCpfCartao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtNum;
    // End of variables declaration//GEN-END:variables
}
