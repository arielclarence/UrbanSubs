/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyek;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class FormMinuman extends javax.swing.JFrame {

    /**
     * Creates new form FormMinuman
     */
    Object[] rows ;
    DefaultTableModel model;
    
    Statement stmt;
    Connection conn;
    PreparedStatement pr;
    ResultSet rs;
    int total  = 0;
    int subtotal = 0;
    
    public FormMinuman() {

        setUndecorated(true);
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        initComponents();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_proyek","root","");
        } catch (Exception ex) {
          
        }
        
        loadminuman();
        
        rows = new Object[]{"Minuman", "Harga", "Qty", "SubTotal"};
        model = new DefaultTableModel(rows , 0);
        jTablecart.setModel(model);
        jTablecart.setDefaultEditor(Object.class, null);
        
        isiMinuman();
        jSpinnerqty.setValue(1);
        
        jButton2.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButtonadd.setOpaque(false);
        jButtonadd.setContentAreaFilled(false);
        jButtonadd.setBorderPainted(false);
        jButtonadd.setFocusPainted(false);
        jButtonadd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnback.setOpaque(false);
        btnback.setContentAreaFilled(false);
        btnback.setBorderPainted(false);
        btnback.setFocusPainted(false);
        btnback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnnext.setOpaque(false);
        btnnext.setContentAreaFilled(false);
        btnnext.setBorderPainted(false);
        btnnext.setFocusPainted(false);
        btnnext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setBorderPainted(false);
        jButton4.setFocusPainted(false);
        jButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButton5.setOpaque(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setBorderPainted(false);
        jButton5.setFocusPainted(false);
        jButton5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setBorderPainted(false);
        jButton3.setFocusPainted(false);
        jButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.getViewport().getView().setBackground(new Color(28,29,31));
        
        jTablecart.getTableHeader().setOpaque(false);
        jTablecart.getTableHeader().setBackground(new Color(28,29,31));
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        
        jTablecart.getTableHeader().setForeground(Color.white);
        jTablecart.setForeground(Color.white);
        
        Font headerFont = new Font("Arial", Font.BOLD, 19);
        jTablecart.getTableHeader().setFont(headerFont);
        
        Font contentFont = new Font("Helvetica", Font.PLAIN, 17);
        jTablecart.setFont(contentFont);
        
        jTablecart.setRowHeight(34);
        
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        txtsubtotal.setForeground(Color.white);
  
        
        
        
        txthargaminuman.setForeground(Color.white);
        txthargaminuman1.setForeground(Color.white);
        txthargaminuman2.setForeground(Color.white);
        
    }
    
    public void isiMinuman(){
        
        rows = new Object[]{"Minuman", "Harga", "Qty", "SubTotal"};
        model = new DefaultTableModel(rows , 0);
        jTablecart.setModel(model);
        jTablecart.setDefaultEditor(Object.class, null);
        for (int i = 0; i < FormMakanan.arrtransminuman.size(); i++) {
            
                transminuman minuman = FormMakanan.arrtransminuman.get(i);
                
//                System.out.println(minuman.getIdMinuman());
                model.addRow(new Object[]{minuman.getMinuman(),minuman.getHarga(),  minuman.getJumlah(), minuman.getSubtotal()});
                jTablecart.setModel(model);
            
        }
    }
    
   
    
    private void berubahtotal()
    {
        subtotal = 0;
        String temp1 = String.valueOf(jSpinnerqty.getValue());
        subtotal = Integer.valueOf(temp1) * Integer.valueOf(txthargaminuman.getText());
        txtsubtotal.setText(String.valueOf(subtotal));
    }
    
    public void refreshminuman()
    {
        model = new DefaultTableModel(rows, 0);
        jComboBoxminuman.setModel((ComboBoxModel<String>) model);
    }
    
    public void loadminuman()
    {
        
        
        try {
//            stmt = conn.createStatement();
                pr = conn.prepareStatement("Select * from menu where idkategori = 4");
            rs = pr.executeQuery();
            
            
            while (rs.next()) {                
                String nama = rs.getString("nama");
//                model.addRow(new Object[]{rs.getString("nama")});
                jComboBoxminuman.addItem(nama);
            }
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    
    public void clearfield()
    {
//        jComboBoxminuman.setSelectedIndex(-1);
//        txtharga.setText("0");
//        txthargaminuman.setText("0");
//        txtsubtotal.setText("0");
//        jSpinnerqty.setValue(0);
        
        jComboBoxminuman.setSelectedIndex(0);
        
        jSpinnerqty.setValue(1);
    }
    
    public void tambah()
    {
        int idMinuman = -1;
        String minuman = jComboBoxminuman.getSelectedItem().toString();
        int subtotal = Integer.parseInt(txtsubtotal.getText().toString());
        int jumlah = Integer.parseInt(jSpinnerqty.getValue().toString());
        int harga = Integer.parseInt(txthargaminuman.getText());
        boolean cektambah=false;
        for (int i = 0; i < FormMakanan.arrmenu.size(); i++) {
            if (minuman.equals(FormMakanan.arrmenu.get(i).getNama())) {
                idMinuman = FormMakanan.arrmenu.get(i).getIdmenu();
            }
        }
        for (transminuman t:FormMakanan.arrtransminuman) {
            if (t.getMinuman().equals(minuman)) {
                t.setJumlah(t.getJumlah()+jumlah);
                t.setSubtotal(t.getSubtotal()+subtotal);
                cektambah=true;

            }
        }
        if (cektambah==false) {
        transminuman baru = new transminuman(idMinuman, jumlah, subtotal, harga, minuman);
        System.out.println(idMinuman);
        FormMakanan.arrtransminuman.add(baru);
        }
        isiMinuman();
       
        
         
        clearfield();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnnext = new javax.swing.JButton();
        txtsubtotal = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSpinnerqty = new javax.swing.JSpinner();
        jButtonadd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablecart = new javax.swing.JTable();
        jComboBoxminuman = new javax.swing.JComboBox<>();
        txthargaminuman = new javax.swing.JTextField();
        btnback = new javax.swing.JButton();
        jLabelminuman = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txthargaminuman1 = new javax.swing.JTextField();
        txthargaminuman2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelminuman1 = new javax.swing.JLabel();
        jLabelminuman2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1379, 905));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnnext.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });
        getContentPane().add(btnnext, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 770, 190, 50));

        txtsubtotal.setBackground(new java.awt.Color(28, 29, 31));
        txtsubtotal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtsubtotal.setBorder(null);
        txtsubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubtotalActionPerformed(evt);
            }
        });
        getContentPane().add(txtsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 360, 120, 32));

        jButton4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 770, 160, 50));

        jButton5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 770, 160, 50));

        jSpinnerqty.setBorder(null);
        jSpinnerqty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerqtyStateChanged(evt);
            }
        });
        getContentPane().add(jSpinnerqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 60, 34));

        jButtonadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonaddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 260, 50));

        jTablecart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablecart.setGridColor(new java.awt.Color(28, 29, 31));
        jScrollPane1.setViewportView(jTablecart);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, 840, 170));

        jComboBoxminuman.setBackground(new java.awt.Color(28, 29, 31));
        jComboBoxminuman.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxminumanItemStateChanged(evt);
            }
        });
        jComboBoxminuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxminumanActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxminuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 144, -1));

        txthargaminuman.setBackground(new java.awt.Color(28, 29, 31));
        txthargaminuman.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txthargaminuman.setText("jTextField1");
        txthargaminuman.setBorder(null);
        txthargaminuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaminumanActionPerformed(evt);
            }
        });
        getContentPane().add(txthargaminuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 134, -1));

        btnback.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        getContentPane().add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 770, 200, 50));

        jLabelminuman.setBackground(new java.awt.Color(0, 255, 204));
        getContentPane().add(jLabelminuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 175, 175));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 50, 20, 20));

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 50, 20, 20));

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 420, 50));

        txthargaminuman1.setBackground(new java.awt.Color(28, 29, 31));
        txthargaminuman1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txthargaminuman1.setText("Rp.");
        txthargaminuman1.setBorder(null);
        txthargaminuman1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaminuman1ActionPerformed(evt);
            }
        });
        getContentPane().add(txthargaminuman1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 362, 40, 30));

        txthargaminuman2.setBackground(new java.awt.Color(28, 29, 31));
        txthargaminuman2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txthargaminuman2.setText("Rp.");
        txthargaminuman2.setBorder(null);
        txthargaminuman2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaminuman2ActionPerformed(evt);
            }
        });
        getContentPane().add(txthargaminuman2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 40, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek/MenuMinuman.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 1110, 890));

        jLabelminuman1.setBackground(new java.awt.Color(0, 255, 204));
        getContentPane().add(jLabelminuman1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabelminuman2.setBackground(new java.awt.Color(0, 255, 204));
        getContentPane().add(jLabelminuman2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 220, 210));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        // TODO add your handling code here:    
        FormCheckOut fck = new FormCheckOut();
        fck.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnnextActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        FormMakanan fm = new FormMakanan();
        fm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void jComboBoxminumanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxminumanItemStateChanged
        // TODO add your handling code here:
       for (int i = 0; i < FormMakanan.arrmenu.size(); i++) {
            menu m = FormMakanan.arrmenu.get(i);         
            if (m.getNama().equals(String.valueOf(jComboBoxminuman.getSelectedItem()))) {
//                System.out.println("sama");
                txthargaminuman.setText(String.valueOf(m.getHarga()));       
            }
        }
        
        
        boolean cekgambar=false;
        
        String[] minuman = {"Coca cola","Sprite", "Orange Juice", "Teh Manis", "Mineral Water"};
            for (int j = 0; j < minuman.length; j++) {

               if (String.valueOf(jComboBoxminuman.getSelectedItem()).equals(minuman[j])) {
                   cekgambar=true;
               }

           } 
            if (cekgambar) {
            for (int i = 0; i < FormMakanan.arrmenu.size(); i++) {
            menu m = FormMakanan.arrmenu.get(i);
            String tempnama;
            if (m.getNama().equals(String.valueOf(jComboBoxminuman.getSelectedItem()))) {
//                System.out.println("sama");
                txthargaminuman.setText(String.valueOf(m.getHarga()));
                
                tempnama = m.getNama();
                if (tempnama.equals("Mineral Water")) {
                    tempnama="mineralwater";
                }
                ImageIcon imageroti = new ImageIcon(System.getProperty("user.dir") + "\\GAMBARPROYEKPBO\\"+tempnama+".jpg");
                jLabelminuman.setIcon(imageroti);
                
            }
        }
            }
            else{
            String tempnama ;
                      tempnama="tandatanya1";
                ImageIcon imageroti = new ImageIcon(System.getProperty("user.dir") + "\\GAMBARPROYEKPBO\\"+tempnama+".jpg");
                jLabelminuman.setIcon(imageroti);
                   
                   
        }
        
        
        
        berubahtotal();
        
    }//GEN-LAST:event_jComboBoxminumanItemStateChanged

    private void jSpinnerqtyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerqtyStateChanged
        // TODO add your handling code here:
        berubahtotal();
    }//GEN-LAST:event_jSpinnerqtyStateChanged

    private void jButtonaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaddActionPerformed
        // TODO add your handling code here:
        if (Integer.valueOf(String.valueOf(jSpinnerqty.getValue())) < 1) {
            JOptionPane.showMessageDialog(this, "kuantiti tidak boleh 0");
        }
        else
        {
            tambah();
        }
    }//GEN-LAST:event_jButtonaddActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        int i = jTablecart.getSelectedRow();
        if (i<0) {
             JOptionPane.showMessageDialog(this, "Belum ada item yang dipilih");
        }
        else{
        model.removeRow(i);
        FormMakanan.arrtransminuman.remove(i);
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        model.setRowCount(0);
        FormMakanan.arrtransminuman.clear();
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtsubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubtotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setExtendedState (FormMinuman.ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FormMakanan fm = new FormMakanan();
        fm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txthargaminumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaminumanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaminumanActionPerformed

    private void txthargaminuman1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaminuman1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaminuman1ActionPerformed

    private void jComboBoxminumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxminumanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxminumanActionPerformed

    private void txthargaminuman2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaminuman2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaminuman2ActionPerformed

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
            java.util.logging.Logger.getLogger(FormMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMinuman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonadd;
    private javax.swing.JComboBox<String> jComboBoxminuman;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelminuman;
    private javax.swing.JLabel jLabelminuman1;
    private javax.swing.JLabel jLabelminuman2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerqty;
    private javax.swing.JTable jTablecart;
    private javax.swing.JTextField txthargaminuman;
    private javax.swing.JTextField txthargaminuman1;
    private javax.swing.JTextField txthargaminuman2;
    private javax.swing.JTextField txtsubtotal;
    // End of variables declaration//GEN-END:variables
}
